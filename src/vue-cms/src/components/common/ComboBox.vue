<script setup lang="ts">
import {onMounted, ref} from "vue";
  import {useCodeStore} from "@/stores/code/codeStore";

  const code = useCodeStore();

  const props = defineProps({
    groupCodeName:{
      Type: String,
      default : ""
    },
    groupCodeId:{
      Type: Number,
      default : 0
    },
    modelValue:{
      Type: String,
      default : ""
    }
  });

  const emit = defineEmits(['update:modelValue']);

  const comboBoxOption = ref([]);

  onMounted(async ()=> {
    const codeList = await code.getCodeList(0, props.groupCodeId, props.groupCodeName, "", "");

    if (codeList.status === 200) {
      comboBoxOption.value = codeList.data;
    }
  });

</script>

<template>
  <select
      :value="modelValue"
      @input="$emit('update:modelValue', $event.target.value)"
    >
    <option value="">{{ $t("common.searchForm.select") }}</option>
    <option v-for="option in comboBoxOption" :value="option.value1">
      {{ option.name }}
    </option>
  </select>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  select {
    padding : 7px 10px;
    width: 170px;
    border: 0.5px solid #{$sliver-light-color};
    border-radius: 5px;
    color: #{$sliver-dark-color};
    margin-right: 10px;
  }

  select:focus {
    outline: none;
    border-color: #{$blue-dark-color};
  }
</style>
