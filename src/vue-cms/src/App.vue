<script setup lang="ts">
import { RouterView } from 'vue-router'
import AlertConfirm from "@/components/common/AlertConfirm.vue";
</script>

<template>
  <div>
    <RouterView />
    <AlertConfirm/>
  </div>
</template>

<style scoped>
</style>
