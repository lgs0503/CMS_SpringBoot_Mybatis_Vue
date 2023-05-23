<script setup lang="ts">

import MenuTitle from "@/components/common/MenuTitle.vue";
import SearchForm from "@/components/common/SearchForm.vue";

import {onMounted, ref} from "vue";
import CommonTable from "@/components/common/CommonTable.vue";
import router from "@/router";
import {API_RESULT_STATUS, VIEW_MODE} from "@/enum/enum";
import type { Ref } from 'vue'
import type {RoleModel} from "@/model/role/roleModel";
import {useRoleStore} from "@/stores/role/roleStore";

const searchKey:Ref<string> = ref("");
const keyword:Ref<string> = ref("");
const roleList:Ref<Array<RoleModel>> = ref([]);

const roleStore = useRoleStore();

const roleCol:Ref<Array<Object>> = ref([
  {
    name: "권한 ID",
    field: "roleId",
    width: "10%",
    visible: true
  },
  {
    name: "권한 명",
    field: "name",
    width: "50%",
    visible: true
  },
  {
    name: "등록자",
    field: "createUser",
    width: "20%",
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

  const result = await roleStore.getRoleListKeyword(searchKey.value, keyword.value);

  if (result.status === API_RESULT_STATUS.SUCCESS) {
    roleList.value = result.data;
  }
}

const roleRowClickEvent = (roleId:number) => {
  router.push(`/admin/role/${roleId}`);
}

const roleAddView = () => {
  router.push(`/admin/role/${VIEW_MODE.ADD_MODE}`);
}

onMounted(async () => {
  await searchEvent();
});

</script>
<template>
  <div class="from">
    <menu-title :title="`권한관리`"/>
    <search-form
        class="search-form"
        v-model:comboBoxModel="searchKey"
        v-model:keywordModel="keyword"
        :groupCodeName="`ROLE_SEARCH_OPTION`"
        @searchEvent="searchEvent"
    />
    <div class="button-from">
      <button class="btn-primary" @click="roleAddView">추가</button>
    </div>
    <div class="table-form">
      <common-table
          :column="roleCol"
          :data="roleList"
          @rowClickEvent="roleRowClickEvent"
          :mainKey="`roleId`"
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