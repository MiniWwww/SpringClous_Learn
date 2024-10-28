<template>
  <div class="container">
    <a-result
        status="success"
        title="购买成功!"
        style="position: absolute;left: 45%"
    >
      <template #extra>
        <a-button key="console" type="primary" @click="router.push('/')">首页</a-button>
        <a-button key="buy" @click="router.push(`/detail/${route.params.id}`)">继续购买</a-button>
      </template>
    </a-result>
  </div>
</template>
<script setup>

import {useRoute, useRouter} from "vue-router";
const route = useRoute();
 let router = useRouter();
</script>
<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  text-align: center;
}
</style>