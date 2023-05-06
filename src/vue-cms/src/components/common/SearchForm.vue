<script setup lang="ts">

  import ComboBox from "@/components/common/ComboBox.vue";

  const props = defineProps({
    groupCodeName:{
      Type: String,
      default : ""
    },
    comboBoxModel:{
      Type: String,
      default : ""
    },
    keywordModel:{
      Type: String,
      default : ""
    }
  });

  const emit = defineEmits([
    'searchEvent'
  ]);
</script>

<template>
  <div class="admin-search-form">
    <ComboBox
        :value="props.comboBoxModel"
        @input="$emit('update:comboBoxModel', $event.target.value)"
        :groupCodeName="props.groupCodeName"
    />
    <input
        :value="props.keywordModel"
        @input="$emit('update:keywordModel', $event.target.value)"
        type="text"
        :placeholder="$t('common.searchForm.keyword_placeholder')"
    />
    <button @click="emit('searchEvent')">{{ $t("common.searchForm.search") }}</button>
  </div>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  .admin-search-form {
    background-color: #{$white-color};
    padding: 10px;
    border : 1px solid #{$black-color};
    border-radius: 5px;
    display: flex;

    input {
      padding : 7px 10px;
      width: 220px;
      border: 0.5px solid #{$sliver-light-color};
      border-radius: 5px;
      color: #{$sliver-dark-color};
      margin-right: 10px;
    }

    input:focus {
      outline: none;
      border-color: #{$blue-dark-color};
    }

    input::placeholder {
      color: #a6a6a6;
    }

    button {
      font-weight: bold;
      padding: 7px 20px;
      background: #{$blue-dark-color};
      border: none;
      border-radius: 5px;
      color: #{$white-color};
      font-size: 13px;
    }

    button:hover {
      cursor: pointer;
      background: #{$blue-deep-dark-color};
    }
  }
</style>
