/**
 * axios 实例化
 */
import axios from "axios";
import {message} from "ant-design-vue";
import 'ant-design-vue/dist/antd.css';
import {useRouter} from "vue-router";
import {useStore} from "../store/main";
import {SET_TOKEN} from "./token";
const store = useStore();
const instance = axios.create({
    baseURL: import.meta.env.VITE_AXIOS_URL,
    timeout: 1000,
    // headers: {'X-Custom-Header': 'foobar'}
});
// 添加请求拦截器
instance.interceptors.request.use(function (config) {

    
    // 在发送请求之前做些什么
    // useStore().loading = true
    // if (localStorage.getItem("token")) {
    //     config.headers.token = localStorage.getItem("token")
    // }
    config.headers["Content-type"] = "application/json;charset=UTF-8";
    return config;
}, function (error) {
    // ElMessage.error(error)

    // 对请求错误做些什么
    return Promise.reject(error);
});
// 添加响应拦截器
instance.interceptors.response.use(function (response) {
    // 2xx 范围内的状态码都会触发该函数。

    const router=useRouter();
    const responseURL = response.request.responseURL;
    console.log(responseURL,":",response)

    if(responseURL.indexOf("login")!=-1){
        if (response.data.code == 200) {
            store.loginStatus=true
            //一般会将后端生成的token进行保存
            // SET_TOKEN(response.data.data)
            localStorage.setItem("cloud_sc_userInfo",JSON.stringify(response.data.data))
        }
    }
    if(response.data.code==200){
        if(response.data.message!=null&&response.data.data==null){
            message.success(response.data.message)
        }
        if(response.data.data != null){
            return response.data.data
        }
    }else {
        message.error(response.data.message)
    }

    // 对响应数据做点什么
    return response.data;
}, function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // ElMessage.error(error)
    // 对响应错误做点什么
    return Promise.reject(error);
});
export default instance