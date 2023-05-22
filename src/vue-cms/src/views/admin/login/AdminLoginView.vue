<script setup lang="ts">
  import {useUserStore} from "@/stores/user/userStore";
  import type {LoginModel} from "@/model/user/userModel";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  import {useI18n} from "vue-i18n";

  let loginModel: LoginModel = {
    userId : "",
    password: ""
  }

  const user = useUserStore();
  const alertConfirm = useAlertConfirmStore();
  const i18n = useI18n();

  const login = async () => {
    const loginResult = await user.login(loginModel);

    const loginStatus = loginResult.status;

    if (loginStatus === 404) {
      alertConfirm.alert(i18n.t('admin.login.alert.login_fail'));
    } else {
      const token = loginResult.data.data;
      sessionStorage.setItem("loginToken", token);
      alertConfirm.alert(i18n.t('admin.login.alert.login_success'), () => {
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
    <h1 class="loginFrom-title">CMS ADMIN LOGIN</h1>
    <div class="loginForm-row">
      <input
          :placeholder="$t('admin.login.input.placeholder.id')"
          type="text"
          v-model="loginModel.userId"
          @keyup.enter="login"
      />
    </div>
    <div class="loginForm-row">
      <input
          :placeholder="$t('admin.login.input.placeholder.password')"
          type="password"
          v-model="loginModel.password"
          @keyup.enter="login"
      />
    </div>
    <div class="loginForm-row">
      <button @click="login">LOGIN</button>
      <button @click="signupPage">SIGNUP</button>
    </div>
  </div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/mixin.scss";

  .loginForm {
    position: absolute;
    padding: 25px 70px 20px 70px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #{$white-color};
    border: 1px solid #{$blue-dark-color};
    display: inline-block;
    border-radius: 10px;

    .loginFrom-title {
      color: #{$blue-dark-color};
      margin-bottom: 15px;
      font-size: 23px;
      font-weight: bold;
    }

    .loginForm-row {
      margin-bottom: 5px;

      input {
        padding : 7px 10px;
        width: 220px;
        border: 0.5px solid #{$sliver-light-color};
        border-radius: 5px;
        color: #{$sliver-dark-color};
      }

      input:focus {
        outline: none;
        border-color: #{$blue-dark-color};
      }

      input::placeholder {
        color: #a6a6a6;
      }

      button {
        width: 241px;
        display: block;
        margin-top: 10px;
        padding: 7px 7px;
        background: #{$blue-dark-color};
        border: none;
        border-radius: 5px;
        color: #{$white-color};
        font-size: 15px;
      }

      button:hover {
        cursor: pointer;
        background: #{$blue-deep-dark-color};
      }
    }
  }
</style>
