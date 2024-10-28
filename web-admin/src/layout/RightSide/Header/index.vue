<script setup lang="ts">
import {MenuUnfoldOutlined,MenuFoldOutlined} from "@ant-design/icons-vue";
import {useStore} from "../../../store/main";
import {toRefs} from "vue";
const {collapsed}=toRefs(useStore())

</script>
<template>
  <a-layout-header style="background: #fff; padding: 0">
    <menu-unfold-outlined
        v-if="collapsed"
        class="trigger"
        @click="() => (collapsed = !collapsed)"
    />
    <menu-fold-outlined v-else class="trigger" @click="() => (collapsed = !collapsed)" />
  </a-layout-header>
</template>


<style scoped>

</style>