<script setup lang="ts">
  import {useUserStore} from "@/stores/user/userStore";
  import type {UserModel} from "@/model/user/userModel";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";

  let userModel: UserModel = {
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
  }

  let passwordChk = "";

  const user = useUserStore();
  const alertConfirm = useAlertConfirmStore();

  const signup = async () => {
    const insertResult = await user.insertUser(userModel);

    const loginStatus = insertResult.status;

    if (loginStatus === 200) {
      alertConfirm.alert("회원가입 완료", () => {
        router.push("/admin/login");
      });
    }
  }

  const back = ()=>{
    router.go(-1);
  }
</script>

<template>
  <div class="signupForm">
    <div class="signupForm-row">
      <label>ID</label>
      <input type="text" placeholder="아이디 입력" v-model="userModel.userId"/>
    </div>
    <div class="signupForm-row">
      <label>PASSWORD</label>
      <input type="password" placeholder="비밀번호 입력" v-model="userModel.password"/>
    </div>
    <div class="signupForm-row">
      <label>PASSWORD CHECK</label>
      <input type="password" placeholder="비밀번호 확인" v-model="passwordChk"/>
    </div>
    <div class="signupForm-row">
      <label>NAME</label>
      <input type="text" placeholder="이름 입력" v-model="userModel.korName"/>
    </div>
    <div class="signupForm-row">
      <label>ENG NAME</label>
      <input type="text" placeholder="영어 이름 입력" v-model="userModel.engName"/>
    </div>
    <div class="signupForm-row">
      <label>BIRTHDAY</label>
      <input type="date" placeholder="생년월일" v-model="userModel.birthday"/>
    </div>
    <div class="signupForm-row">
      <label>GENDER</label>
      <select v-model="userModel.gender">
        <option selected value="">선택</option>
        <option value="UG001">남자</option>
        <option value="UG002">여자</option>
      </select>
    </div>
    <div class="signupForm-row">
      <label>ADDRESS</label>
      <input type="text" placeholder="주소 입력" v-model="userModel.address"/>
      <button>주소찾기</button>
    </div>
    <div class="signupForm-row">
      <label>ADDRESS DETAIL</label>
      <input type="text" placeholder="상세주소 입력" v-model="userModel.addressDtl"/>
    </div>
    <div class="signupForm-row">
      <label>PHONE NUMBER</label>
      <input type="text" placeholder="연락처 입력" v-model="userModel.phoneNum"/>
    </div>
    <div class="signupForm-row">
      <label>E-MAIL</label>
      <input type="text" placeholder="이메일 입력" v-model="userModel.email"/>
    </div>
    <div class="signupForm-row">
      <label>PROFILE IMAGE</label>
      <input type="file"/>
      <input type="hidden" v-model="userModel.fileId"/>
      <div class="image-thumbnail"></div>
    </div>
    <input type="hidden" v-model="userModel.roleId"/>
    <div class="signupForm-row">
      <button @click="signup">회원가입</button>
      <button @click="back">취소</button>
    </div>
  </div>
</template>
<style>
</style>
