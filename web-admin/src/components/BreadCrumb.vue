<script setup lang="ts">
import {useRoute} from "vue-router";
 const route = useRoute();
console.log(route.meta.name)

</script>
<template>
  <a-breadcrumb style="margin: 10px">
    <a-breadcrumb-item>{{route.matched[1].meta.name}}</a-breadcrumb-item>
    <template v-for="(item,i) in route.matched">
      <a-breadcrumb-item v-if="i!==0&&i!==1">
        {{item.meta.name}}
      </a-breadcrumb-item>
    </template>
  </a-breadcrumb>
</template>



<style scoped>

</style>