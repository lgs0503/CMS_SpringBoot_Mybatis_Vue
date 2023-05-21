<script setup lang="ts">
  import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

  const props = defineProps({
    isHidden: {
      Type: Boolean,
      default: false
    },
    title: {
      Type: String,
      default: ""
    }
  });

  const emits = defineEmits([
    'closeEvent'
  ]);
</script>

<template>
  <div v-if="props.isHidden" class="commonModalPopup">
    <div class="commonModalPopup-header">
      {{ props.title }}
      <button @click="$emit('closeEvent')">
        <font-awesome-icon :icon="['far', 'circle-xmark']" />
      </button>
    </div>
    <div class="commonModalPopup-body">
      <slot></slot>
    </div>
  </div>
  <div v-if="props.isHidden" class="commonModalPopup-Background"></div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  .commonModalPopup {
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-50%, -50%);
    z-index: 4001;
    background-color: #{$white-color};

    .commonModalPopup-header{
      background-color: #{$blue-dark-color};
      color: #{$white-color};
      font-weight: bold;
      font-size: 20px;
      padding: 10px 20px;

      button {
        border: none;
        background: none;
        color: #{$white-color};
        font-size: 20px;
        float: right;
        position: absolute;
        right: 5px;
      }

      button:hover{
        color: #{$black-color};
        cursor: pointer;
      }
    }

    .commonModalPopup-body {
      padding: 20px;
    }
  }

  .commonModalPopup-Background{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.6);
    z-index: 4000;
  }

</style>
