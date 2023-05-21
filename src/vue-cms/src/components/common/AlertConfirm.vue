<script setup lang="ts">
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  const alertConfirm = useAlertConfirmStore();

  const alertConfirmOk = () => {

    alertConfirm.isHidden = false;

    if (alertConfirm.callback) {
      alertConfirm.callback();
    }
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
    <div class="body" v-html="alertConfirm.message"></div>
    <div class="footer">
      <button @click="alertConfirmOk">{{ $t("common.alert_confirm.ok") }}</button>
      <button v-if="alertConfirm.isConfirm" @click="confirmCancel">{{ $t("common.alert_confirm.cancel") }}</button>
    </div>
  </div>
  <div v-if="alertConfirm.isHidden" class="commonAlertConfirm-Background"></div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  .commonAlertConfirm {
    position: absolute;
    top: 45%;
    left: 50%;
    transform: translate(-50%, -50%);
    border: none;
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
      line-height: 20px;
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
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.6);
    z-index: 5000;
  }
</style>
