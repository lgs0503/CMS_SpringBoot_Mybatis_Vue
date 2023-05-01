<script setup lang="ts">
  import {useUserStore} from "@/stores/user/userStore";
  import type {UserModel, ValidationMsgModel} from "@/model/user/userModel";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  import {reactive} from "vue";

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
    passwordChk: "" as string,
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
    } as UserModel
  });

  const user = useUserStore();
  const alertConfirm = useAlertConfirmStore();

  const validationMsgInit = () => {
    Object.keys(state.validationMsg).forEach((value:string) => {
      state.validationMsg[value] = "";
    });
  }

  const validationCheck = (): boolean => {

    let validationResult: boolean = true;

    validationMsgInit();

    const requiredMsg: string = "필수 입력값입니다.";

    if (state.userModel.userId === "") {
      state.validationMsg.userId = `아이디는 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.password === "") {
      state.validationMsg.password = `비밀번호는 ${requiredMsg}`;
      validationResult = false;
    } else {
      if (state.userModel.password !== state.passwordChk) {
        state.validationMsg.passwordChk = "비밀번호와 비밀번호 확인을 동일하게 입력해주세요.";
        validationResult = false;
      }
    }

    if (state.userModel.korName === "") {
      state.validationMsg.korName = `이름은 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.birthday === "") {
      state.validationMsg.birthday = `생년월일은 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.birthday === "") {
      state.validationMsg.birthday = `생년월일은 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.gender === "") {
      state.validationMsg.gender = `성별은 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.address === "") {
      state.validationMsg.address = `주소는 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.addressDtl === "") {
      state.validationMsg.addressDtl = `상세주소는 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.phoneNum === "") {
      state.validationMsg.phoneNum = `연락처는 ${requiredMsg}`;
      validationResult = false;
    }

    if (state.userModel.email === "") {
      state.validationMsg.email = `이메일은 ${requiredMsg}`;
      validationResult = false;
    }

    return validationResult;
  }

  const signup = async () => {

    if (validationCheck()) {

      const insertResult = await user.insertUser(state.userModel);

      const loginStatus = insertResult.status;

      if (loginStatus === 200) {
        alertConfirm.alert("회원가입 완료 관리자 계정은 승인완료 이후 로그인이 가능합니다.", () => {
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
    <div class="signupForm-row">
      <label>ID</label>
      <input type="text" placeholder="아이디 입력" v-model="state.userModel.userId"/>
      <div>{{ state.validationMsg.userId }}</div>
    </div>
    <div class="signupForm-row">
      <label>PASSWORD</label>
      <input type="password" placeholder="비밀번호 입력" v-model="state.userModel.password"/>
      <div>{{ state.validationMsg.password }}</div>
    </div>
    <div class="signupForm-row">
      <label>PASSWORD CHECK</label>
      <input type="password" placeholder="비밀번호 확인" v-model="state.passwordChk"/>
      <div>{{ state.validationMsg.passwordChk }}</div>
    </div>
    <div class="signupForm-row">
      <label>NAME</label>
      <input type="text" placeholder="이름 입력" v-model="state.userModel.korName"/>
      <div>{{ state.validationMsg.korName }}</div>
    </div>
    <div class="signupForm-row">
      <label>ENG NAME</label>
      <input type="text" placeholder="영어 이름 입력" v-model="state.userModel.engName"/>
    </div>
    <div class="signupForm-row">
      <label>BIRTHDAY</label>
      <input type="date" placeholder="생년월일" v-model="state.userModel.birthday"/>
      <div>{{ state.validationMsg.birthday }}</div>
    </div>
    <div class="signupForm-row">
      <label>GENDER</label>
      <select v-model="state.userModel.gender">
        <option selected value="">선택</option>
        <option value="UG001">남자</option>
        <option value="UG002">여자</option>
      </select>
      <div>{{ state.validationMsg.gender }}</div>
    </div>
    <div class="signupForm-row">
      <label>ADDRESS</label>
      <input type="text" placeholder="주소 입력" v-model="state.userModel.address"/>
      <button>주소찾기</button>
      <div>{{ state.validationMsg.address }}</div>
    </div>
    <div class="signupForm-row">
      <label>ADDRESS DETAIL</label>
      <input type="text" placeholder="상세주소 입력" v-model="state.userModel.addressDtl"/>
      <div>{{ state.validationMsg.addressDtl }}</div>
    </div>
    <div class="signupForm-row">
      <label>PHONE NUMBER</label>
      <input type="text" placeholder="연락처 입력" v-model="state.userModel.phoneNum"/>
      <div>{{ state.validationMsg.phoneNum }}</div>
    </div>
    <div class="signupForm-row">
      <label>E-MAIL</label>
      <input type="text" placeholder="이메일 입력" v-model="state.userModel.email"/>
      <div>{{ state.validationMsg.email }}</div>
    </div>
    <div class="signupForm-row">
      <label>PROFILE IMAGE</label>
      <input type="file"/>
      <input type="hidden" v-model="state.userModel.fileId"/>
      <div class="image-thumbnail"></div>
    </div>
    <input type="hidden" v-model="state.userModel.roleId"/>
    <div class="signupForm-row">
      <button @click="signup">회원가입</button>
      <button @click="back">취소</button>
    </div>
  </div>
</template>
<style>
</style>
