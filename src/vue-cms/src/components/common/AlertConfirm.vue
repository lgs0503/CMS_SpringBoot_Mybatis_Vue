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
  <div class="commonAlertConfirm-Background"></div>
</template>
<style>
</style>
