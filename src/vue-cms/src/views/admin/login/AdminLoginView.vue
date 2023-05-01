<script setup lang="ts">
  import {useUserStore} from "@/stores/user/userStore";
  import type {LoginModel} from "@/model/user/userModel";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";

  let loginModel: LoginModel = {
    userId : "",
    password: ""
  }

  const user = useUserStore();
  const alertConfirm = useAlertConfirmStore();

  const login = async () => {
    const loginResult = await user.login(loginModel);

    const loginStatus = loginResult.status;

    if (loginStatus === 404) {
      alertConfirm.alert("아이디와 비밀번호를 확인해주세요.");
    } else {
      const token = loginResult.data.data;
      sessionStorage.setItem("loginToken", token);
      alertConfirm.alert("로그인 성공", () => {
        router.push("/admin/home");
      });
    }
  }

  const signupPage = () => {
    router.push("/admin/signup");
  }
</script>

<template>
  <div class="loginForm">
    <div class="loginForm-row">
      <input placeholder="아이디 입력" v-model="loginModel.userId"/>
    </div>
    <div class="loginForm-row">
      <input placeholder="비밀번호 입력" v-model="loginModel.password"/>
    </div>
    <div class="loginForm-row">
      <button @click="login">로그인</button>
      <button @click="signupPage">회원가입</button>
    </div>
  </div>
</template>
<style>
</style>
