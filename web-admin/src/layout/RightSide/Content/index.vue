<script setup lang="ts">
import BreadCrumb from "../../../components/BreadCrumb.vue";


</script>
<template>
  <a-layout-content style="margin: 0 16px;">
    <!--面包屑-->
    <BreadCrumb/>
    <!--二级路由-->
    <div :style="{ padding: '15px', background: '#fff', minHeight: '800px' }">
      <router-view/>
    </div>
  </a-layout-content>
</template>
