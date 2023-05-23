<script setup lang="ts">

  import MenuTitle from "@/components/common/MenuTitle.vue";

  import {onMounted, ref} from "vue";
  import {useRoute} from "vue-router";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  import type { Ref } from 'vue'
  import {API_RESULT_STATUS, VIEW_MODE} from "@/enum/enum";
  import {useRoleStore} from "@/stores/role/roleStore";
  import type {RoleModel} from "@/model/role/roleModel";

  const roleStore = useRoleStore();
  const alertConfirm = useAlertConfirmStore();

  const route = useRoute();
  const role:Ref<RoleModel> = ref({
    roleId: 0,
    name: "",
    description: "",
    useYn: "",
    createUser: "",
    createDate: "",
    updateUser: "",
    updateDate: "",
  });

  const roleId = ref(Number(route.params.roleId));

  const searchEvent = async () => {

    if (roleId.value !== VIEW_MODE.ADD_MODE) {

      const result = await roleStore.getRole(roleId.value);

      if (result.status === API_RESULT_STATUS.SUCCESS) {

        role.value = result.data;
      }
    }
  }

  const saveRole = () => {
    alertConfirm.confirm("저장하시겠습니까?", async () => {

      if (saveRoleValidationCheck()) {

        if (roleId.value === VIEW_MODE.ADD_MODE) {

          const result = await roleStore.insertRole(role.value);

          if (result.status === API_RESULT_STATUS.SUCCESS) {
            alertConfirm.alert("저장되었습니다.", async () => {
              router.back();
            });
          }
        } else {

          const result = await roleStore.updateRole(role.value);

          if (result.status === API_RESULT_STATUS.SUCCESS) {
            alertConfirm.alert("저장되었습니다.", async () => {
              await searchEvent();
            });
          }
        }
      }
    });
  }

  const saveRoleValidationCheck = ():boolean => {

    let resultValidation:boolean = true;

    if (role.value.name === "") {

      alertConfirm.alert("권한 명 은 필수 입력 값 입니다.", () => {
        resultValidation = false;
      });

      return resultValidation;
    }

    return resultValidation;
  }

  const deleteRole = () => {
    alertConfirm.confirm("삭제하시겠습니까?", async () => {

      const deleteRoleId:Array<number> = [
          roleId.value
      ];

      const result = await roleStore.deleteRole(deleteRoleId);

      if (result.status === API_RESULT_STATUS.SUCCESS) {
        alertConfirm.alert("삭제되었습니다.", async () => {
            router.back();
        });
      }
    });
  }

  const pageBack = () => {
    router.push("/admin/role");
  }

  onMounted(async () => {
    await searchEvent();
  });

</script>
<template>
  <div class="from">
    <menu-title :title="`유저관리 상세`"/>

    <div class="button-from">
      <button class="btn-primary" @click="saveRole">저장</button>
      <button class="btn-primary" @click="deleteRole" v-if="roleId !== VIEW_MODE.ADD_MODE">삭제</button>
      <button class="btn-primary" @click="pageBack">목록</button>
    </div>

    <table>
      <tbody>
        <tr>
          <th>권한 ID</th>
          <td>
            <input type="text" v-model="role.roleId" disabled v-if="roleId !== VIEW_MODE.ADD_MODE"/>
            <div v-if="roleId === VIEW_MODE.ADD_MODE">자동부여</div>
          </td>
          <th>권한명</th>
          <td>
            <input type="text" v-model="role.name"/>
          </td>
        </tr>

        <tr>
          <th>설명</th>
          <td colspan="3">
            <input type="text" v-model="role.description"/>
          </td>
        </tr>

        <tr>
          <th>최초 등록자</th>
          <td>
            <input type="text" v-model="role.createUser" disabled/>
          </td>
          <th>최초 등록일</th>
          <td>
            <input type="date" v-model="role.createDate" disabled/>
          </td>
        </tr>

        <tr>
          <th>최종 수정자</th>
          <td>
            <input type="text" v-model="role.updateUser" disabled/>
          </td>
          <th>최종 수정일</th>
          <td>
            <input type="date" v-model="role.updateDate" disabled/>
          </td>
        </tr>
      </tbody>
    </table>

  </div>
</template>
<style lang="scss" scoped>
@import "../src/assets/variables.scss";

.from{
  padding: 30px;
  height: 100%;

  .button-from {
    margin-top: 10px;
    margin-bottom: 10px;
    text-align: right;

    button {
      margin-left: 5px;
    }
  }

  table {
    background-color: #{$sliver-bright-color};
    width: 100%;
    margin-bottom: 30px;
    font-size: 12px;

    tbody{
      tr{
        border: 1px solid #{$black-color};
        background-color: #{$white-color};

        th{
          padding: 5px;
          border: 1px solid #{$black-color};
          background-color: #{$blue-dark-color};
          color: #{$white-color};
          font-weight: bold;
          text-align: left;
          max-width: 120px;
          vertical-align: middle;
        }

        td{
          padding: 5px;
          border: 1px solid #{$black-color};
          vertical-align: middle;

          input {
            width: calc(100% - 7px);
            color: #{$sliver-dark-color};
          }
        }
      }
    }
  }
}

.popup-button-from {
  margin-top: 10px;
  text-align: right;

  button {
    margin-left: 5px;
  }
}

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
</style>