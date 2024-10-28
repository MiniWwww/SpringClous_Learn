<script setup lang="ts">
import {reactive, computed, onMounted, watch, ref, toRef, toRefs} from 'vue';
import 'ant-design-vue/dist/antd.css';
import { userService } from '../../api/user/user';
import { useRouter } from 'vue-router';
import {useStore} from "../../store/main";
import {RegisterForm,LoginForm} from "../../api/user/types";

const store=useStore()
const router=useRouter();
const data = reactive({
  loginForm: {} as LoginForm,
  registerForm: {} as RegisterForm
});
const  activeKey=ref('1')
const {loginForm,registerForm} =toRefs(data)
async function login() {
 return await userService.login(loginForm.value)
}
async function register() {
  return await userService.register(registerForm.value)
}

const disabled = computed(() => {
  return !(loginForm.value.username && loginForm.value.password);
});

const disabled2 = computed(() => {
  return !(registerForm.value.username && registerForm.value.password && registerForm.value.email);
});

watch(() => store.loginStatus, (newValue) => {
  if (newValue) {
    router.push('/')
  }
})


</script>

<template>
  <div class="main">
    <div class="loginbox">
    <a-tabs v-model:activeKey="activeKey" type="card">
        <a-tab-pane key="1" tab="登录">
          <a-form :model="data.loginForm" name="horizontal_login" layout="horizontal" autocomplete="off">
            <a-form-item label="账号" name="username" :rules="[{ required: true, message: '请输入你的账号' }]">
              <a-input v-model:value="data.loginForm.username" size="large">
                <template #prefix>
                  <UserOutlined class="site-form-item-icon" />
                </template>
              </a-input>
            </a-form-item>

            <a-form-item label="密码" name="password" :rules="[{ required: true, message: '请输入你的密码' }]">
              <a-input-password v-model:value="data.loginForm.password" size="large">
                <template #prefix>
                  <LockOutlined class="site-form-item-icon" />
                </template>
              </a-input-password>
            </a-form-item>

            <a-form-item>
              <a-button :disabled="disabled" type="primary" html-type="submit" size="large" style="width: 100%;"
                        @click="login">登录</a-button>
            </a-form-item>
          </a-form>
      </a-tab-pane>
        <a-tab-pane key="2" tab="注册">
          <a-form :model="registerForm" name="horizontal_login" layout="horizontal" autocomplete="off">
            <a-form-item label="账号" name="username" :rules="[{ required: true, message: '请输入你的账号' }]">
              <a-input v-model:value="registerForm.username" size="large">
                <template #prefix>
                  <UserOutlined class="site-form-item-icon" />
                </template>
              </a-input>
            </a-form-item>

            <a-form-item label="密码" name="password" :rules="[{ required: true, message: '请输入你的密码' }]">
              <a-input-password v-model:value="registerForm.password" size="large">
                <template #prefix>
                  <LockOutlined class="site-form-item-icon" />
                </template>
              </a-input-password>
            </a-form-item>

            <a-form-item label="邮箱" name="email" :rules="[{ required: true, message: '请输入你的邮箱' }]">
              <a-input v-model:value="registerForm.email" size="large">
                <template #prefix>
                  <paper-clip-outlined class="site-form-item-icon"  />
                </template>
              </a-input>
            </a-form-item>

            <a-form-item>
              <a-button :disabled="disabled2" type="primary" html-type="submit" size="large" style="width: 100%;"
                        @click="register">注册</a-button>
            </a-form-item>
          </a-form>
        </a-tab-pane>
      </a-tabs>

    </div>
  </div>
</template>

<style scoped lang="scss">
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: right;
  align-items: center;
  background-color: #f0f2f5;
  min-width: 100%;
  background-image: url("../../assets/carl-heyerdahl-KE0nC8-58MQ-unsplash.jpg");
  background-size: cover;
  .loginbox {
    width: 400px;
    height: 380px;
    padding-top: 20px;
    display: flex;
    justify-content: center;
    background-color: #fff;
    margin-right: 200px;
    border-radius: 1ch;

    .ant-form {
      width: 100%;
      height: 80%;
      padding: 30px;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }
  }
}</style>