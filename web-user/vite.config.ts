import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import Components from 'unplugin-vue-components/vite'
//ant-design-vue
import {AntDesignVueResolver} from "unplugin-vue-components/resolvers"

import AutoImport from "unplugin-auto-import/vite"
// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        AutoImport({
            //安装两行后你会发现在组件中不用再导入ref，reactive等
            // imports: ['vue', 'vue-router'],
            dts: "src/auto-import.d.ts",
            //ant-design-vue
            resolvers: [AntDesignVueResolver()]
        }),
        Components({
            //ant-design-vue   importStyle = false 样式就没了
            resolvers: [AntDesignVueResolver({importStyle: true, resolveIcons: true})],
        }),
    ],
    server:{
        port:3001
    }
})


