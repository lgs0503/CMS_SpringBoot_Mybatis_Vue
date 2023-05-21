<script setup lang="ts">
  import {useUserStore} from "@/stores/user/userStore";
  import type {UserModel, ValidationMsgModel} from "@/model/user/userModel";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  import {reactive} from "vue";
  import {useI18n} from "vue-i18n";

  const state = reactive({
    validationMsg: {
      userId: "",
      password: "",
      passwordChk: "",
      korName: "",
      birthday: "",
      gender: "",
      address: "",
      addressDtl: "",
      phoneNum: "",
      email: ""
    } as ValidationMsgModel ,
    userModel: {
      userNo: 0,
      userId: "",
      password: "",
      korName: "",
      engName: "",
      birthday: "",
      gender: "",
      address: "",
      addressDtl: "",
      phoneNum: "",
      email: "",
      useYn: "",
      fileId: 0,
      roleId: 0
    } as UserModel,
    passwordChk: "" as string
  });

  const user = useUserStore();
  const alertConfirm = useAlertConfirmStore();
  const i18n = useI18n();

  const validationMsgInit = () => {
    Object.keys(state.validationMsg).forEach((value:string) => {
      state.validationMsg[value] = "";
    });
  }

  const validationCheck = (): boolean => {

    validationMsgInit();

    let validationResult: boolean = true;

    const requiredMsg: string = i18n.t('admin.signup.validationMsg.required');

    if (state.userModel.userId === "") {
      state.validationMsg.userId = i18n.t('admin.signup.validationMsg.id') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.password === "") {
      state.validationMsg.password = i18n.t('admin.signup.validationMsg.password') + requiredMsg;
      validationResult = false;
    } else {
      if (state.userModel.password !== state.passwordChk) {
        state.validationMsg.passwordChk = i18n.t('admin.signup.validationMsg.passwordChk');
        validationResult = false;
      }
    }

    if (state.userModel.korName === "") {
      state.validationMsg.korName = i18n.t('admin.signup.validationMsg.korName') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.birthday === "") {
      state.validationMsg.birthday = i18n.t('admin.signup.validationMsg.birthday') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.gender === "") {
      state.validationMsg.gender = i18n.t('admin.signup.validationMsg.gender') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.address === "") {
      state.validationMsg.address = i18n.t('admin.signup.validationMsg.address') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.addressDtl === "") {
      state.validationMsg.addressDtl = i18n.t('admin.signup.validationMsg.addressDtl') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.phoneNum === "") {
      state.validationMsg.phoneNum = i18n.t('admin.signup.validationMsg.phoneNum') + requiredMsg;
      validationResult = false;
    }

    if (state.userModel.email === "") {
      state.validationMsg.email = i18n.t('admin.signup.validationMsg.email') + requiredMsg;
      validationResult = false;
    }

    return validationResult;
  }

  const signup = async () => {

    if (validationCheck()) {

      /** 파일 업로드 추가 **/

      const insertResult = await user.insertUser(state.userModel);

      const loginStatus = insertResult.status;

      if (loginStatus === 200) {
        alertConfirm.alert(i18n.t('admin.signup.alert.signup_success'), () => {
          router.push("/admin/login");
        });
      }
    }
  }

  const back = () => {
    router.go(-1);
  }
</script>

<template>
  <div class="signupForm">
    <h1 class="signupForm-title">CMS ADMIN SIGNUP</h1>
    <div class="signupForm-row">
      <label>ID</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.id')" v-model="state.userModel.userId"/>
      <div class="validation-msg">{{ state.validationMsg.userId }}</div>
    </div>
    <div class="signupForm-row">
      <label>PASSWORD</label>
      <input type="password" :placeholder="$t('admin.signup.input.placeholder.password')" v-model="state.userModel.password"/>
      <div class="validation-msg">{{ state.validationMsg.password }}</div>
    </div>
    <div class="signupForm-row">
      <label>PASSWORD CHECK</label>
      <input type="password" :placeholder="$t('admin.signup.input.placeholder.passwordChk')" v-model="state.passwordChk"/>
      <div class="validation-msg">{{ state.validationMsg.passwordChk }}</div>
    </div>
    <div class="signupForm-row">
      <label>NAME</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.korName')" v-model="state.userModel.korName"/>
      <div class="validation-msg">{{ state.validationMsg.korName }}</div>
    </div>
    <div class="signupForm-row">
      <label>ENG NAME</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.engName')" v-model="state.userModel.engName"/>
    </div>
    <div class="signupForm-row">
      <label>BIRTHDAY</label>
      <input type="date" :placeholder="$t('admin.signup.input.placeholder.birthday')" v-model="state.userModel.birthday"/>
      <div class="validation-msg">{{ state.validationMsg.birthday }}</div>
    </div>
    <div class="signupForm-row">
      <label>GENDER</label>
      <select v-model="state.userModel.gender">
        <option selected value="">선택</option>
        <option value="UG001">남자</option>
        <option value="UG002">여자</option>
      </select>
      <div class="validation-msg">{{ state.validationMsg.gender }}</div>
    </div>
    <div class="signupForm-row">
      <label>ADDRESS</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.address')" v-model="state.userModel.address"/>
      <button>{{ $t("admin.signup.button.addressSearch") }}</button>
      <div class="validation-msg">{{ state.validationMsg.address }}</div>
    </div>
    <div class="signupForm-row">
      <label>ADDRESS DETAIL</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.addressDtl')" v-model="state.userModel.addressDtl"/>
      <div class="validation-msg">{{ state.validationMsg.addressDtl }}</div>
    </div>
    <div class="signupForm-row">
      <label>PHONE NUMBER</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.phoneNum')" v-model="state.userModel.phoneNum"/>
      <div class="validation-msg">{{ state.validationMsg.phoneNum }}</div>
    </div>
    <div class="signupForm-row">
      <label>E-MAIL</label>
      <input type="text" :placeholder="$t('admin.signup.input.placeholder.email')" v-model="state.userModel.email"/>
      <div class="validation-msg">{{ state.validationMsg.email }}</div>
    </div>
    <div class="signupForm-row">
      <label>PROFILE IMAGE</label>
      <input type="file"/>
      <input type="hidden" v-model="state.userModel.fileId"/>
      <div class="image-thumbnail"></div>
    </div>
    <input type="hidden" v-model="state.userModel.roleId"/>
    <div class="signupForm-row buttonForm">
      <button @click="signup">{{ $t("admin.signup.button.signup") }}</button>
      <button @click="back">{{ $t("admin.signup.button.cancel") }}</button>
    </div>
  </div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/mixin.scss";

  .signupForm{
    position: absolute;
    padding: 25px 70px 20px 70px;
    top: 7%;
    left: 50%;
    transform: translate(-50%, 0);
    background-color: #{$white-color};
    border: 1px solid #{$blue-dark-color};
    display: inline-block;
    border-radius: 10px;

    .signupForm-title {
      color: #{$blue-dark-color};
      margin-bottom: 15px;
      font-size: 23px;
      font-weight: bold;
    }

    .buttonForm{
      text-align: right;
    }

    .signupForm-row{
      margin-bottom: 5px;

      label {
        display: block;
        font-size: 13px;
        font-weight: bold;
        color:#{$sliver-dark-color};
        margin-bottom: 2px;
      }

      input {
        margin-bottom: 5px;
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

      select {
        padding : 7px 10px;
        width: 100px;
        border: 0.5px solid #{$sliver-light-color};
        border-radius: 5px;
        color: #{$sliver-dark-color};
        margin-bottom: 5px;
      }

      button {
        font-weight: bold;
        padding: 7px 20px;
        background: #{$blue-dark-color};
        border: none;
        border-radius: 5px;
        color: #{$white-color};
        font-size: 13px;
        margin-left: 10px;
      }

      button:hover {
        cursor: pointer;
        background: #{$blue-deep-dark-color};
      }

      .validation-msg{
        color: #{$red-color};
        font-size: 12px;
      }
    }
  }
</style>
