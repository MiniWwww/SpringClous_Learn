import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import { HomeOutlined, PaperClipOutlined, TableOutlined } from "@ant-design/icons-vue";

// 2. 配置路由
const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        redirect: "home",
        component: () => import("../pages/index/index.vue"),
        children: [
            {
                path: "home",
                name: "home",
                meta: { icon: HomeOutlined, name: "主页" },
                component: () => import("../pages/index/home/index.vue")
            },
            {
                path: "users",
                name: "users",
                meta: { icon: TableOutlined, name: "用户管理" },
                component: () => import("../pages/index/users/index.vue")
            },
            {
                path: "products",
                name: "products",
                meta: { icon: TableOutlined, name: "商品管理" },
                component: () => import("../pages/index/products/index.vue")
            },
            {
                path: "orders",
                name: "orders",
                meta: { icon: TableOutlined, name: "订单管理" },
                component: () => import("../pages/index/orders/index.vue")
            },
            {
                path: "comments",
                name: "comments",
                meta: { icon: TableOutlined, name: "评论管理" },
                component: () => import("../pages/index/comments/index.vue")
            },

        ]
    },
    {
        path: "/login",
        name: "登陆",
        component: () => import("../pages/login/Login.vue")
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