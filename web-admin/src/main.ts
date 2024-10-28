import { createApp } from 'vue'
import './style/style.css'
import App from './App.vue'
import router from "./router/index";
import {Button} from "ant-design-vue";
// @ts-ignore
import {createPinia} from "pinia";

createApp(App)
    .use(Button)
    .use(createPinia())
    .use(router)
    .mount('#app')

