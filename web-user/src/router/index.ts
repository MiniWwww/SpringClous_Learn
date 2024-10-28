import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";
import {HomeOutlined,PaperClipOutlined,TableOutlined} from "@ant-design/icons-vue";

// 2. 配置路由
const routes: Array<RouteRecordRaw> = [
    {
        path:"/",
        name:"主页",
        component:()=>import("../pages/index/index.vue")
    },
    {
        path:'/detail/:id',
        name:"detail",
        component:()=>import("../pages/detail.vue")
    },
    {
        path:'/result/:id',
        name:"result",
        component:()=>import("../pages/Result.vue")
    },
    {
      path:"/login",
      name:"登陆",
      component:()=>import("../pages/login/Login.vue")
    },


];
// 1.返回一个 router 实列，为函数，里面有配置项（对象） history
const router = createRouter({
    history: createWebHistory(),
    routes,
});
// router.beforeEach((to, from,next)=>{
//
// })

// 3导出路由   然后去 main.ts 注册 router.ts
export default router