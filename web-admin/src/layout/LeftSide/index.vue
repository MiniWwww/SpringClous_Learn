<script setup lang="ts">
import {onMounted,  ref } from "vue";
import {useStore} from "../../store/main";
import {toRefs} from "vue";
import {useRoute, useRouter} from "vue-router";
const router=useRouter()
const route=useRoute()
const openKeys = ref<string[]>([route.path.split("/")[1]])
const selectedKeys = ref<string[]>([route.name])
const {collapsed}=toRefs(useStore())
function to(path:string) {
  router.push({
    name:path
  })
}
</script>
<template>
  <a-layout-sider v-model:collapsed="collapsed" :trigger="null" collapsible>
    <div class="logo" />
    <!--菜单-->
    <a-menu v-model:selectedKeys="selectedKeys" v-model:openKeys="openKeys"  theme="dark" mode="inline">
        <template v-for="(item) in useRoute().matched[0].children">
            <a-menu-item :key="item.path"  v-if="!item.children"
            @click="to(item.name)"
            >
              <component :is="item.meta.icon"></component>
              <span>{{item.meta.name}}</span>
            </a-menu-item>
            <a-sub-menu :key="item.path" v-if="item.children">
              <template #title>{{item.meta.name}}</template>
              <template #icon>
                <component :is="item.meta.icon"></component>
              </template>
              <template v-for="(son) in item.children">
                  <a-menu-item
                  @click="to(son.name)"
                  >
                    <span>{{son.meta.name}}</span>
                  </a-menu-item>
              </template>
            </a-sub-menu>


        </template>

    </a-menu>
  </a-layout-sider>
</template>
<style scoped>

</style>