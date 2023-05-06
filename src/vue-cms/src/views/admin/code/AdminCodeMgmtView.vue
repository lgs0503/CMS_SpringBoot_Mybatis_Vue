<script setup lang="ts">

import MenuTitle from "@/components/common/MenuTitle.vue";
import SearchForm from "@/components/common/SearchForm.vue";
import CommonTable from "@/components/common/CommonTable.vue";

import {onMounted, ref} from "vue";
import {useCodeStore} from "@/stores/code/codeStore";

const searchKey = ref("");
const keyword = ref("");
const groupCodeKey = ref("groupCodeId");
const groupCodeList = ref([]);
const groupCodeListColumn = ref([
  {
    field : "groupCodeId",
    name: "ID",
    visible: true,
    width: 30
  },
  {
    field : "name",
    name: "그룹코드명",
    visible: true,
    width: 100
  },
  {
    field : "createUser",
    name: "등록자",
    visible: true,
    width: 100
  }
]);

const codeList = ref([]);
const codeListColumn = ref([
  {
    field : "codeId",
    name: "코드 ID",
    visible: true,
    width: 30
  },
  {
    field : "name",
    name: "코드명",
    visible: true,
    width: 100
  },
  {
    field : "groupCodeId",
    name: "그룹코드 ID",
    visible: true,
    width: 30
  },
  {
    field : "groupCodeName",
    name: "그룹코드 명",
    visible: true,
    width: 100
  },
  {
    field : "createUser",
    name: "등록자",
    visible: true,
    width: 100
  }
]);

const code = useCodeStore();

const searchEvent = async () => {

  const result = await code.getGroupCodeListKeyword(searchKey.value, keyword.value);

  if (result.status === 200) {
    groupCodeList.value = result.data;
  }
}

const rowClickEvent = async (value:number) => {

  const result = await code.getCodeList(value.indexKey);

  if (result.status === 200) {
    codeList.value = result.data;
  }
}

onMounted(async () => {
  await searchEvent();
});
</script>
<template>
  <div class="from">
    <menu-title :title="`코드관리`"/>
    <search-form
        class="search-form"
        v-model:comboBoxModel="searchKey"
        v-model:keywordModel="keyword"
        :groupCodeName="`CODE_SEARCH_OPTION`"
        @searchEvent="searchEvent"
    />
    <div class="table-form">
      <div class="table-master">
        <div>
          <div>그룹코드</div>
          <div>
            <button>추가</button>
            <button>삭제</button>
          </div>
        </div>
        <common-table
            :column="groupCodeListColumn"
            :data="groupCodeList"
            :main-key="groupCodeKey"
            @rowClickEvent="rowClickEvent"
        />
      </div>
      <div class="table-detail">
        <div>
          <div>코드</div>
          <div>
            <button>추가</button>
            <button>삭제</button>
          </div>
        </div>
        <common-table
            :column="codeListColumn"
            :data="codeList"
        />
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
@import "../src/assets/variables.scss";

.from{
  padding: 30px;
  min-height: 1000px;
  background-color: #{$sliver-bright-color};

  .search-form{
    margin-top: 20px;
  }
  .table-form {
    display: flex;
    margin-top: 20px;

    .table-master{
      width: calc( 30% - 5px );
      margin-right: 10px;
    }
    .table-detail {
      width: calc( 70% - 5px );
    }
  }
}
</style>