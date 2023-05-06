<script setup lang="ts">

  defineProps({
    title:{
      Type: String,
      default : ""
    }
  });

</script>

<template>
  <div class="admin-content-title">{{title}}</div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  .admin-content-title {
    font-size: 20px;
    font-weight: bold;
    border-left: double 10px #{$blue-dark-color};
    padding-left: 10px;
    height: 28px;
    line-height: 25px;
    color: #{$sliver-dark-color};
  }
</style>
