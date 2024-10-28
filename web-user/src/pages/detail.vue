<template>
    <div class="container">
      <a-card :title="item && item.name" style="margin: 24px;height: fit-content;width: 800px">
        <div class="content">
          <div class="image-container">
            <a-image :src="item.img" style="width: 100%; height: 400px" />
          </div>
          <div class="description-container">
            <div>
              <h4>价格:</h4> ¥{{ item.price }}
            </div>
            <div>
              <h4>描述:</h4> {{ item.description }}
            </div>
            <div>
              <h4>材质:</h4> {{ item.material }}
            </div>
             <div style="margin-bottom: 80px">
               <h4>数量</h4> <a-input-number id="inputNumber" v-model:value="value" :min="1" :max="10" />
             </div>
             <div>
               <a-button type="primary" danger @click="buy">立即购买</a-button>
             </div>
<!--            <a-descriptions-item label="商品描述">{{ item.description }}</a-descriptions-item>-->
<!--            <a-descriptions-item label="价格">¥{{ item.price }}</a-descriptions-item>-->
            <!-- 其他商品信息 -->
          <div>
        </div>
        </div>
        </div>
      </a-card>
    </div>
</template>

<script setup="ts">
import {ref, onMounted, reactive, toRefs} from 'vue';
import {useRoute, useRouter} from 'vue-router';
import {productService} from "../api/product/product.ts";
import {GET_USEREMAIL, GET_USERID, GET_USERNAME} from "../utils/token.ts";
import {OrderService} from "../api/order/order.ts";

const router = useRouter();
const route = useRoute();
const value = ref(1);
const state=reactive({
  item:{}
})
const {item}=toRefs(state)
const order=reactive({
  productId:route.params.id,
  quantity:value.value,
  username:GET_USERNAME(),
  email:GET_USEREMAIL(),
  price:null
})



const getProduct = () => {
  const itemId = route.params.id;
  productService.getById(itemId).then(res => {
    state.item = res; // 更新响应式对象的值
    order.price=res.price
  });
};
onMounted(async () => {
  getProduct()
});
const buy = () => {
  OrderService.add(order).then(res=>{
    if(res.code===200){
        router.push(`/result/${route.params.id}`)
    }
  })

}
</script>
<style scoped>
.container {
  display: flex;
  justify-content: center;
  padding: 20px 0 400px 200px;
}

.content {
  display: flex;
  align-items: center;
}

.image-container {
  flex: 1;
}

.description-container {
  flex: 1;
  margin-left: 24px;
}
.description-container div{
  margin-bottom: 8px;
}
</style>
