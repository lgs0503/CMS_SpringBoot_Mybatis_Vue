<script setup lang="ts">

  import MenuTitle from "@/components/common/MenuTitle.vue";
  import SearchForm from "@/components/common/SearchForm.vue";

  import {onMounted, ref} from "vue";
  import {useCodeStore} from "@/stores/code/codeStore";
  import CommonTable from "@/components/common/CommonTable.vue";
  import router from "@/router";
  import {API_RESULT_STATUS, VIEW_MODE} from "@/enum/enum";
  import type { Ref } from 'vue'
  import type {GroupCodeModel} from "@/model/code/codeModel";

  const searchKey:Ref<string> = ref("");
  const keyword:Ref<string> = ref("");
  const groupCodeList:Ref<Array<GroupCodeModel>> = ref([]);

  const codeStore = useCodeStore();

  const groupCodeCol:Ref<Array<Object>> = ref([
    {
      name: "그룹코드 ID",
      field: "groupCodeId",
      width: "10%",
      visible: true
    },
    {
      name: "그룹코드명",
      field: "name",
      width: "30%",
      visible: true
    },
    {
      name: "그룹코드명(한글)",
      field: "korName",
      width: "30%",
      visible: true
    },
    {
      name: "등록자",
      field: "createUser",
      width: "10%",
      visible: true
    },
    {
      name: "등록일",
      field: "createDate",
      width: "20%",
      visible: true
    }
  ]);

  const searchEvent = async () => {

    const result = await codeStore.getGroupCodeListKeyword(searchKey.value, keyword.value);

    if (result.status === API_RESULT_STATUS.SUCCESS) {
      groupCodeList.value = result.data;
    }
  }

  const groupCodeRowClickEvent = (groupCodeId:number) => {
    router.push(`/admin/code/${groupCodeId}`);
  }

  const groupCodeAddView = () => {
    router.push(`/admin/code/${VIEW_MODE.ADD_MODE}`);
  }

  onMounted(async () => {
    await searchEvent();
  });

</script>
<template>
  <div class="from">
    <menu-title :title="`그룹코드관리`"/>
    <search-form
        class="search-form"
        v-model:comboBoxModel="searchKey"
        v-model:keywordModel="keyword"
        :groupCodeName="`CODE_SEARCH_OPTION`"
        @searchEvent="searchEvent"
    />
    <div class="button-from">
      <button class="btn-primary" @click="groupCodeAddView">추가</button>
    </div>
    <div class="table-form">
      <common-table
          :column="groupCodeCol"
          :data="groupCodeList"
          @rowClickEvent="groupCodeRowClickEvent"
          :mainKey="`groupCodeId`"
      />
    </div>
  </div>

</template>
<style lang="scss" scoped>
@import "../src/assets/variables.scss";

.from{
  height: 100%;
  padding: 30px;
  background-color: #{$sliver-bright-color};

  .search-form{
    margin-top: 20px;
  }

  .table-form {
    margin-top: 10px;
    width: 100%;
  }

  .button-from {
    margin-top: 10px;
    text-align: right;

    .btn-primary {
      font-weight: bold;
      padding: 5px 20px;
      background: #{$blue-dark-color};
      border: none;
      border-radius: 5px;
      color: #{$white-color};
      font-size: 11px;
    }

    .btn-primary:hover {
      cursor: pointer;
      background: #{$blue-deep-dark-color};
    }
  }
}
</style>