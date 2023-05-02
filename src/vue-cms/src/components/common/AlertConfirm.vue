<script setup lang="ts">
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  const alertConfirm = useAlertConfirmStore();

  const alertConfirmOk = () => {

    if (alertConfirm.callback) {
      alertConfirm.callback();
    }

    alertConfirm.isHidden = false;
  }

  const confirmCancel = () => {
    alertConfirm.isHidden = false;
  }
</script>

<template>
  <div v-if="alertConfirm.isHidden" class="commonAlertConfirm">
    <div class="header">
      {{ alertConfirm.title }}
    </div>
    <div class="body">
      {{ alertConfirm.message }}
    </div>
    <div class="footer">
      <button @click="alertConfirmOk">확인</button>
      <button v-if="alertConfirm.isConfirm" @click="confirmCancel">취소</button>
    </div>
  </div>
  <div v-if="alertConfirm.isHidden" class="commonAlertConfirm-Background"></div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  .commonAlertConfirm {
    position: absolute;
    top:50%;
    left:50%;
    transform: translate(-50%, -50%);
    border:none;
    display: inline-block;
    z-index: 5001;
    border-radius: 5px;
    background: white;

    .header {
      background-color: #{$blue-dark-color};
      color: #{$white-color};
      padding: 10px 20px;
      border-radius: 5px 5px 0 0;
    }

    .body {
      padding: 20px;
      min-width: 200px;
      color: #{$sliver-dark-color};
      font-size: 12px;
      font-weight: bold;
    }

    .footer {
      padding: 10px;
      text-align: right;

      button {
        background-color: #{$blue-dark-color};
        color: #{$white-color};
        border: none;
        padding: 5px 20px;
        border-radius: 3px;
        margin-left:5px;
      }

      button:hover{
        cursor: pointer;
        background-color: #{$blue-deep-dark-color};
      }
    }
  }

  .commonAlertConfirm-Background {
    position: absolute;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.6);
    z-index: 5000;
  }
</style>
