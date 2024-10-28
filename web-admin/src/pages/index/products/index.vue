<template>
  <a-button type="primary" @click="addpageShow">
    <template #icon>
      <PlusOutlined />
    </template>
  </a-button>
  <MyTable :dataSource="state.dataSource" :columns="columns"  ref="childComp"/>
  <a-modal v-model:visible="visible" title="添加商品" @ok="finshproduct" >
    <a-form :model="ProductObj" name="basic" :label-col="{ span: 8 }" :wrapper-col="{ span: 16 }" autocomplete="off">
      <div style="width: 100%;height: 100%;display: flex;flex-direction: row;">
        <div>
          <template v-for="(item,index) in state.leftfArr">
            <a-form-item :label="item.title" name="item.dataIndex" v-if='item.type!="action"&&item.type!="id"'>
              <a-input v-model:value="ProductObj[item.dataIndex]" v-if='item.type!="textarea"' />
              <a-textarea v-model:value="ProductObj[item.dataIndex]" v-if='item.type=="textarea"' />
            </a-form-item>
          </template>
        </div>

        <div >
          <template v-for="(item,index) in state.rightArr">
            <a-form-item :label="item.title" name="item.dataIndex" v-if='item.type!="action"'>
              <a-input v-model:value="ProductObj[item.dataIndex]"  />
            </a-form-item>
          </template>
        </div>
      </div>
    </a-form>


  </a-modal>
</template>

<script lang="ts" setup>
import {onMounted, reactive, ref} from "vue";
import MyTable from "../../../components/table/MyTable.vue";
import {productService} from "../../../api/product/product"
import {message} from "ant-design-vue";
import 'ant-design-vue/dist/antd.css';
/**
 * 列的接口
 */
interface Column{
  title:string
  dataIndex?:string
  type:string,
  member?:{
    delete?:Function
    edit?:Function
  }

}

const columns:Column [] = [
  {
    title: '序号',
    dataIndex: 'id',
    type: 'id',
  },
  {
    title: '商品名称',
    dataIndex: 'name',
    type: 'String',
  },
  {
    title: '描述',
    dataIndex: 'description',
    type: 'textarea',
  },
  {
    title: '价格',
    dataIndex: 'price',
    type: 'Number',
  },
  {
    title: '库存',
    dataIndex: 'stock',
    type: 'Number',
  },
  {
    title: '材质',
    dataIndex: 'material',
    type: 'String',
  },
  // {
  //   title: '是否上架',
  //   dataIndex: 'isAvailable',
  //   type: 'Number',
  // },
  {
    title: '操作',
    type: 'action',
    //有哪些操作 现在只支持这两个操作 你需要就加入 后面跟上 相应的函数就行 不需要就直接不加这个属性就好
    member:{
      delete:deleteById,
      edit:handleOk
    }
  },
]
let ProductObj=reactive({})
const childComp = ref(null);
const state = reactive({
  dataSource: [], // 使用响应式对象包装 dataSource
  leftfArr:columns.slice(0,columns.length/2),
  rightArr:columns.slice(columns.length/2,columns.length)
});

onMounted(() => {
  getAllProduct()
})
const getAllProduct = () => {
  productService.list().then(res => {
    state.dataSource = res; // 更新响应式对象的值
  });
};
/**
 * 删除的回调
 * @param id 唯一标识
 */
function deleteById(id:string) {
  productService.delete(id).then(res=>{
    if(res.code==200){
      state.dataSource.forEach((item,index)=>{
        if(item.id==id){
          state.dataSource.splice(index,1)
        }
      })
    }
  })

}

/**
 * 编辑成功的回调
 */
function handleOk(obj: any) {
  productService.update(obj).then(res => {
    if (res.code == 200) {
      const index = state.dataSource.findIndex(item => item.id == obj['id']);
      if (index !== -1) {
        // 使用数组的 splice 方法替换数据源中指定的项
        state.dataSource.splice(index, 1, obj);
      }
      childComp.value.closeModel();
    }
  })
}
const visible=ref(false)
const addpageShow=()=>{
  visible.value=!visible.value
}
const finshproduct=()=>{
  productService.add(ProductObj).then(res=>{
    if(res.id!=null){
      state.dataSource.push(res);
      message.success("添加商品成功")
      visible.value=false
      ProductObj={}

    }
  })
}



</script>

