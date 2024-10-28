<template>
  <a-table :dataSource="props.dataSource" :columns="props.columns"  :loading="loading">
    <template #bodyCell="{ column, record }">
      <template v-if="column.type === 'tags'">
        <span>
          <a-tag>
            {{ record[column.dataIndex] }}
          </a-tag>
        </span>
      </template>

      <template v-if="column.type === 'price'">
        <span>
            ¥ {{ record[column.dataIndex] }}
        </span>
      </template>

      <!-- 操作 -->
      <template v-else-if="column.type === 'action'">
        <template v-if="column.member.edit">
          <a @click="ShowModel(record, column)">编辑</a>
        </template>


        <a-divider type="vertical" v-if="Object.keys(column.member).length > 1" />
        <template v-if="column.member.delete">
          <a-popconfirm title="确认删除吗?" ok-text="确定" cancel-text="取消" @confirm="column.member.delete(record.id)"
            @cancel="cancelDelete">
            <a>删除</a>
          </a-popconfirm>
        </template>
      </template>
    </template>


  </a-table>

  <!-- 弹出框 -->
  <a-modal v-model:visible="visible" title="Basic Modal" @ok="handleOk" >
    <!-- <div style="display: flex;">
       <div></div>
       <div></div>
     </div>     -->
    <a-form :model="RecordObj" name="basic" :label-col="{ span: 8 }" :wrapper-col="{ span: 16 }" autocomplete="off">
      <div style="width: 100%;height: 100%;display: flex;flex-direction: row;">
        <div >
          <template v-for="(item,index) in state.leftfArr">
          <a-form-item :label="item.title" name="item.dataIndex" v-if='item.type!="action"'>
          <a-input v-model:value="RecordObj[item.dataIndex]"  />
        </a-form-item>
      </template>
        </div> 

        <div >
          <template v-for="(item,index) in state.rightArr">
          <a-form-item :label="item.title" name="item.dataIndex" v-if='item.type!="action"'>
          <a-input v-model:value="RecordObj[item.dataIndex]"  />
        </a-form-item>
      </template>
        </div> 
      </div>
    </a-form>


  </a-modal>
</template>
<script lang="ts" setup>
import {reactive, ref, watch} from 'vue';

const props = defineProps<{
  dataSource: any[],
  columns: any[],
}>();
const loading=ref(false)

watch(() => props.dataSource, (newVal) => {
  loading.value = newVal.length === 0 ? true : false;
});

//暂时存放id和函数 编辑得用
const state = reactive({
  id: '',
  fun: Function,
  //编辑弹窗的内部
  leftfArr:props.columns.slice(0,props.columns.length/2),
  rightArr:props.columns.slice(props.columns.length/2,props.columns.length)
})
let RecordObj = reactive({})

/**
 * 取消删除回调
 */
const cancelDelete = (e: MouseEvent) => {
  console.log(e);
}
/**
 * 弹出窗的状态
 */
const visible = ref(false)

/**
 * 展示编辑弹窗
 * @param record 编辑的记录
 * @param column 列的信息
 */
function ShowModel(record: any, column: any) {
  state.id = record.id
  state.fun = column.member?.edit
  Object.assign(RecordObj, record)
  visible.value = !visible.value
}
function closeModel() {
  setTimeout(()=>{
    visible.value = !visible.value
  },1000)

}
defineExpose({
  closeModel
})

function handleOk() {
  state.fun(RecordObj)
}
</script>