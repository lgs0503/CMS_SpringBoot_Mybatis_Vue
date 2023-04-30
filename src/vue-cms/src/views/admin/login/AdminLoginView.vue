<script setup lang="ts">
  import {useUserStore} from "@/stores/user/userStore";
  import type {Login} from "@/model/user/userModel";

  let loginModel: Login = {
    userId : "",
    password: ""
  }

  const user = useUserStore();

  const login = async () => {
    const loginResult = await user.login(loginModel);
    const loginStatus = loginResult.data.status;

    if (loginStatus === 404) {
      alert("아이디와 비밀번호를 확인해주세요.");
    } else {
      const token = loginResult.data.data;
      sessionStorage.setItem("loginToken", token);
      alert("로그인 성공");
    }
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
      <button @click="login()">로그인</button>
      <button>회원가입</button>
    </div>
  </div>
</template>
<style>
</style>
