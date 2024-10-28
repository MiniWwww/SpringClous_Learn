<template>
  <MyTable :dataSource="state.dataSource" :columns="columns"  ref="childComp"/>
</template>

<script lang="ts" setup>
import {onMounted, reactive, ref} from "vue";
import MyTable from "../../../components/table/MyTable.vue";
import {OrderService} from "../../../api/order/order"
import dayjs from "dayjs"
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

const childComp = ref(null);
const state = reactive({
  dataSource: [] // 使用响应式对象包装 dataSource
});

onMounted(() => {
  getAllOrder()
})
const getAllOrder = () => {
  OrderService.list().then(res => {
    state.dataSource = res; // 更新响应式对象的值
    state.dataSource.forEach(item=>{
      item.orderDate=dayjs(item.orderDate).format('YYYY-MM-DD')

    })
  });
};
/**
 * 删除的回调
 * @param id 唯一标识
 */
function deleteById(id:string) {
  OrderService.deleteOrderById(id).then(res=>{
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
  OrderService.updateOrder(obj).then(res => {
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

const columns:Column [] = [
  {
    title: '订单号',
    dataIndex: 'id',
    type: 'Number',
  },
  {
    title: '商品序列号',
    dataIndex: 'productId',
    type: 'Number',
  },
  {
    title: '规格',
    dataIndex: 'quantity',
    type: 'Number',
  },
  {
    title: '总价',
    dataIndex: 'totalPrice',
    type: 'price',
  },
  {
    title: '下单用户',
    dataIndex: 'customerName',
    type: 'String',
  },
  {
    title: '用户邮箱',
    dataIndex: 'customerEmail',
    type: 'String',
  },
  {
    title: '下单时间',
    dataIndex: 'orderDate',
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

</script>

