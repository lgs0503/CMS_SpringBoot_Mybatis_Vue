import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useAlertConfirmStore = defineStore('alertConfirm', () => {

  let message = ref("");
  let title = ref("");
  let callback = ref(() => {});
  let isConfirm = ref(false);
  let isHidden = ref(false);

  const alert = (messageParam: string, callbackParam?: () => void) => {

    message.value = messageParam;
    title.value = "Alert";
    isConfirm.value = false;

    if (callbackParam) {
      callback.value = callbackParam;
    }

    isHidden.value = true;

  }

  const confirm = (messageParam: string, callbackParam?: () => void) => {

    message.value = messageParam;
    title.value = "confirm";
    isConfirm.value = true;

    if (callbackParam) {
      callback.value = callbackParam;
    }

    isHidden.value = true;
  }

  return { message, title, callback ,isHidden, isConfirm, alert, confirm }
})
