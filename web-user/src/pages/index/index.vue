<template>
  <a-layout class="layout">
    <a-layout-header>
      <div class="logo" />
      <a-menu
          v-model:selectedKeys="selectedKeys"
          theme="dark"
          mode="horizontal"
          :style="{ lineHeight: '64px' }"

      >
        <a-menu-item key="1">主页</a-menu-item>
<!--        <a-menu-item key="2">nav 2</a-menu-item>-->
<!--        <a-menu-item key="3">nav 3</a-menu-item>-->
      </a-menu>
    </a-layout-header>
    <a-layout-content style="height: 900px;padding: 20px;overflow-y: scroll">
      <div style="background-color:#fff;padding: 20px;height: fit-content;margin-top: 10px;">
        <a-row :gutter="16">
          <a-col :md="6" v-for="(item, index) in state.dataSource" :key="index">
            <router-link :to="`/detail/${item.id}`">
            <a-card class="card" :title="item.name" style="margin-bottom: 20px;height: 400px;text-align: center;cursor: pointer">
              <a-image :src="item.img" :alt="item.name" style="width: 100%;height: 260px" :preview="false"></a-image>
              <p>{{ item.description }}</p>
              <p>价格: ¥{{ item.price }}</p>
              <!-- 其他商品信息 -->
            </a-card>
            </router-link>
          </a-col>
        </a-row>
      </div>
    </a-layout-content>
    <a-layout-footer style="text-align: center">
      Ant Design ©2018 Created by Ant UED
    </a-layout-footer>
  </a-layout>
</template>
<script lang="ts" setup>
import {onMounted, reactive, ref} from 'vue';
import {productService} from "../../api/product/product";
const selectedKeys = ref<string[]>(['1']);
const state = reactive({
  dataSource: [], // 使用响应式对象包装 dataSource
});

onMounted(() => {
  getAllProduct()
})
const getAllProduct = () => {
  productService.list().then(res => {
    state.dataSource = res; // 更新响应式对象的值
  });
};

</script>
<style scoped>
.site-layout-content {
  min-height: 280px;
  padding: 24px;
  background: #fff;
}
#components-layout-demo-top .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}
.ant-row-rtl #components-layout-demo-top .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

[data-theme='dark'] .site-layout-content {
  background: #141414;
}
.layout{
  height: fit-content;
}
.card:hover{
  border: 1px solid #418ff7;
}

</style>
