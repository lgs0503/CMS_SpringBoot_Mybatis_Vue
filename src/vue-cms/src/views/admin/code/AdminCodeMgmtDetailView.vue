<script setup lang="ts">

  import MenuTitle from "@/components/common/MenuTitle.vue";

  import {onMounted, ref} from "vue";
  import {useCodeStore} from "@/stores/code/codeStore";
  import CommonTable from "@/components/common/CommonTable.vue";
  import {useRoute} from "vue-router";
  import router from "@/router";
  import {useAlertConfirmStore} from "@/stores/common/alertConfirmStore";
  import ModelPopup from "@/components/common/ModelPopup.vue";
  import type { Ref } from 'vue'
  import type {CodeModel, GroupCodeModel} from "@/model/code/codeModel";
  import {API_RESULT_STATUS, VIEW_MODE} from "@/enum/enum";

  const codeStore = useCodeStore();
  const alertConfirm = useAlertConfirmStore();

  const route = useRoute();
  const groupCode:Ref<GroupCodeModel> = ref({
    groupCodeId:0,
    name:"",
    korName:"",
    description:"",
    useYn:"",
    createUser:"",
    createDate:"",
    updateUser:"",
    updateDate:""
  });

  const code:Ref<CodeModel> = ref({
    codeId:0,
    groupCodeId:0,
    name:"",
    korName:"",
    description:"",
    value1:"",
    value2:"",
    value3:"",
    value4:"",
    value5:"",
    useYn:"",
    sort:0,
    createUser:"",
    createDate:"",
    updateUser:"",
    updateDate:""
  });

  const codeList:Ref<Array<CodeModel>> = ref([]);
  const codePopupIsHidden:Ref<boolean> = ref(false);

  const groupCodeId = ref(Number(route.params.groupCodeId));

  const codeCol:Ref<Array<Object>> = ref([
    {
      name: "코드ID",
      field: "codeId",
      width: "50px",
      visible: true
    },
    {
      name: "코드명",
      field: "name",
      width: "50px",
      visible: true
    },
    {
      name: "코드명(한글)",
      field: "korName",
      width: "50px",
      visible: true
    },
    {
      name: "설명",
      field: "description",
      width: "200px",
      visible: true
    },
    {
      name: "REF-1",
      field: "value1",
      width: "70px",
      visible: false
    },
    {
      name: "REF-2",
      field: "value2",
      width: "70px",
      visible: false
    },
    {
      name: "REF-3",
      field: "value3",
      width: "70px",
      visible: false
    },
    {
      name: "REF-4",
      field: "value4",
      width: "70px",
      visible: false
    },
    {
      name: "REF-5",
      field: "value5",
      width: "70px",
      visible: false
    },
    {
      name: "순서",
      field: "sort",
      width: "70px",
      visible: true
    },
    {
      name: "등록자",
      field: "createUser",
      width: "80px",
      visible: true
    },
    {
      name: "등록일",
      field: "createDate",
      width: "80px",
      visible: false
    },
    {
      name: "수정자",
      field: "updateUser",
      width: "80px",
      visible: false
    },
    {
      name: "수정일",
      field: "updateDate",
      width: "80px",
      visible: false
    }
  ]);

  const searchEvent = async () => {

    if (groupCodeId.value !== VIEW_MODE.ADD_MODE) {
      const resultGroupCode = await codeStore.getGroupCode(groupCodeId.value);

      if (resultGroupCode.status === API_RESULT_STATUS.SUCCESS) {

        groupCode.value = resultGroupCode.data;

        const resultCodeList = await codeStore.getCodeList(0, groupCodeId.value);

        if (resultCodeList.status === API_RESULT_STATUS.SUCCESS) {
          codeList.value = resultCodeList.data;
        }
      }
    }
  }

  const codeRowClickEvent = async (codeId:number) => {

    codePopupIsHidden.value = true;

    const resultCode = await codeStore.getCode(codeId);

    if (resultCode.status === API_RESULT_STATUS.SUCCESS) {
      code.value = resultCode.data;
    }
  }

  const codeAddPopupOpen = () => {
    codePopupIsHidden.value = true;

    code.value = {
      codeId:0,
      groupCodeId:groupCodeId.value,
      name:"",
      korName:"",
      description:"",
      value1:"",
      value2:"",
      value3:"",
      value4:"",
      value5:"",
      useYn:"",
      sort:0,
      createUser:"",
      createDate:"",
      updateUser:"",
      updateDate:""
    };
  }

  const closeEvent = () => {
    codePopupIsHidden.value = false;
  }

  const saveGroupCode = () => {
    alertConfirm.confirm("저장하시겠습니까?", async () => {

      if (saveGroupCodeValidationCheck()) {

        if (groupCodeId.value === VIEW_MODE.ADD_MODE) {

          const result = await codeStore.insertGroupCode(groupCode.value);

          if (result.status === API_RESULT_STATUS.SUCCESS) {
            alertConfirm.alert("저장되었습니다.", async () => {
              groupCodeId.value = Number(result.data.insertKey);
              await searchEvent();
              await router.push(`/admin/code/${result.data.insertKey}`);
            });
          }
        } else {

          const result = await codeStore.updateGroupCode(groupCode.value);

          if (result.status === API_RESULT_STATUS.SUCCESS) {
            alertConfirm.alert("저장되었습니다.", async () => {
              await searchEvent();
            });
          }
        }
      }
    });
  }

  const saveGroupCodeValidationCheck = ():boolean => {

    let resultValidation:boolean = true;

    if (groupCode.value.name === "") {

      alertConfirm.alert("그룹 코드명은 필수 입력 값 입니다.", () => {
        resultValidation = false;
      });

      return resultValidation;
    }

    if (groupCode.value.korName === "") {

      alertConfirm.alert("그룹 코드명(한글)은 필수 입력 값 입니다.", () => {
        resultValidation = false;
      });

      return resultValidation;
    }

    return resultValidation;
  }

  const deleteGroupCode = () => {
    alertConfirm.confirm("삭제하시겠습니까?<br/> 하위 코드 데이터들이 모두 삭제됩니다.", async () => {

      const deleteGroupCodeId:Array<number> = [
          groupCodeId.value
      ];

      const result = await codeStore.deleteGroupCode(deleteGroupCodeId);

      if (result.status === API_RESULT_STATUS.SUCCESS) {
        alertConfirm.alert("삭제되었습니다.", async () => {

          const codeDeleteResult = await codeStore.deleteCodeGroupCodeId(groupCodeId.value);

          if (codeDeleteResult.status === API_RESULT_STATUS.SUCCESS) {
            router.back();
          }
        });
      }
    });
  }

  const saveCode = () => {

    alertConfirm.confirm("저장하시겠습니까?", async () => {

      if (saveCodeValidationCheck()) {

        if (code.value.codeId === VIEW_MODE.ADD_MODE) {

          const result = await codeStore.insertCode(code.value);

          if (result.status === API_RESULT_STATUS.SUCCESS) {
            alertConfirm.alert("저장되었습니다.", async () => {
              await searchEvent();
              codePopupIsHidden.value = false;
            });
          }

        } else {

          const result = await codeStore.updateCode(code.value);

          if (result.status === API_RESULT_STATUS.SUCCESS) {
            alertConfirm.alert("저장되었습니다.", async () => {
              await searchEvent();
              codePopupIsHidden.value = false;
            });
          }
        }
      }
    });
  }

  const saveCodeValidationCheck = ():boolean => {

    let resultValidation:boolean = true;

    if (code.value.name === "") {

      alertConfirm.alert("코드명은 필수 입력 값 입니다.", () => {
        resultValidation = false;
      });

      return resultValidation;
    }

    if (code.value.korName === "") {

      alertConfirm.alert("코드명(한글)은 필수 입력 값 입니다.", () => {
        resultValidation = false;
      });

      return resultValidation;
    }

    return resultValidation;
  }

  const deleteCode = () => {

    alertConfirm.confirm("삭제하시겠습니까?", async () => {

      const deleteCodeIds:Array<number> = [
        code.value.codeId
      ];

      const result = await codeStore.deleteCode(deleteCodeIds);

      if (result.status === API_RESULT_STATUS.SUCCESS) {
        alertConfirm.alert("삭제되었습니다.", async () => {
          await searchEvent();
          codePopupIsHidden.value = false;
        });
      }
    });
  }

  const sortChangeNumber = (e: InputEvent) => {

    const eventTarget = e.target as HTMLInputElement;

    const regex = /[^0-9]/g;
    if (regex.test(eventTarget.value)) {
      eventTarget.value = eventTarget.value.replace(regex, '');
    }
  }

  const pageBack = () => {
    router.push("/admin/code");
  }

  onMounted(async () => {
    await searchEvent();
  });

</script>
<template>
  <div class="from">
    <menu-title :title="`그룹코드관리 상세`"/>

    <div class="button-from">
      <button class="btn-primary" @click="saveGroupCode">저장</button>
      <button class="btn-primary" @click="deleteGroupCode" v-if="groupCodeId !== VIEW_MODE.ADD_MODE">삭제</button>
      <button class="btn-primary" @click="pageBack">목록</button>
    </div>

    <table>
      <tbody>
        <tr>
          <th>그룹코드 ID</th>
          <td>
            <input type="text" v-model="groupCode.groupCodeId" disabled v-if="groupCodeId !== VIEW_MODE.ADD_MODE"/>
            <div v-if="groupCodeId === VIEW_MODE.ADD_MODE">자동부여</div>
          </td>
          <th>그룹코드 명</th>
          <td>
            <input type="text" v-model="groupCode.name"/>
          </td>
          <th>그룹코드 명 (한글)</th>
          <td>
            <input type="text" v-model="groupCode.korName"/>
          </td>
        </tr>

        <tr>
          <th>설명</th>
          <td colspan="5">
            <input type="text" v-model="groupCode.description"/>
          </td>
        </tr>

        <tr>
          <th>최초 등록자</th>
          <td>
            <input type="text" v-model="groupCode.createUser" disabled/>
          </td>
          <th>최초 등록일</th>
          <td>
            <input type="date" v-model="groupCode.createDate" disabled/>
          </td>
        </tr>

        <tr>
          <th>최종 수정자</th>
          <td>
            <input type="text" v-model="groupCode.updateUser" disabled/>
          </td>
          <th>최종 수정일</th>
          <td>
            <input type="date" v-model="groupCode.updateDate" disabled/>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-if="groupCodeId !== VIEW_MODE.ADD_MODE">

      <menu-title :title="`코드관리`"/>

      <div class="button-from">
        <button class="btn-primary" @click="codeAddPopupOpen">추가</button>
      </div>

      <div class="table-form">
        <common-table
            :column="codeCol"
            :data="codeList"
            @rowClickEvent="codeRowClickEvent"
            :mainKey="`codeId`"
        />
      </div>
    </div>
  </div>

  <model-popup
      :isHidden="codePopupIsHidden"
      :title="`코드상세`"
      @closeEvent="closeEvent"
  >
    <div class="popup-from">
      <div class="popup-row">
        <div class="popup-th">
          <label>코드 ID</label>
        </div>
        <div class="popup-td">
          <input v-if="code.codeId !== VIEW_MODE.ADD_MODE" type="text" v-model="code.codeId" disabled/>
          <div v-if="code.codeId === VIEW_MODE.ADD_MODE">자동입력</div>
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>그룹코드 ID</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.groupCodeId" disabled/>
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>코드 명</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.name" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>코드 명 (한글)</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.korName" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>설명</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.description" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>REF-1</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.value1" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>REF-2</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.value2" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>REF-3</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.value3" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>REF-4</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.value4" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>REF-5</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.value5" />
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>SORT</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.sort" @input="sortChangeNumber"/>
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>최초 등록자</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.createUser" disabled/>
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>최초 등록일</label>
        </div>
        <div class="popup-td">
          <input type="date" v-model="code.createDate" disabled/>
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>최종 수정자</label>
        </div>
        <div class="popup-td">
          <input type="text" v-model="code.updateUser" disabled/>
        </div>
      </div>
      <div class="popup-row">
        <div class="popup-th">
          <label>최종 등록일</label>
        </div>
        <div class="popup-td">
          <input type="date" v-model="code.updateDate" disabled/>
        </div>
      </div>
    </div>

    <div class="popup-button-from">
      <button class="btn-primary" @click="saveCode">저장</button>
      <button class="btn-primary" @click="deleteCode" v-if="code.codeId !== VIEW_MODE.ADD_MODE">삭제</button>
    </div>
  </model-popup>
</template>
<style lang="scss" scoped>
@import "../src/assets/variables.scss";

.from{
  padding: 30px;
  min-height: 1000px;
  background-color: #{$sliver-bright-color};

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

.popup-from {
  width: 400px;
  font-size: 12px;
  border-bottom: 1px solid #{$black-color};

  .popup-row {
    display: flex;

    .popup-th {
      padding: 5px;
      border-top: 1px solid #{$black-color};
      border-left: 1px solid #{$black-color};
      background-color: #{$blue-dark-color};
      color: #{$white-color};
      width: 150px;
      font-weight: bold;
      height: 20px;
      line-height: 20px;
    }

    .popup-td {
      vertical-align: middle;
      padding: 5px;
      border-top: 1px solid #{$black-color};
      border-right: 1px solid #{$black-color};
      width: 300px;
      height: 20px;
      line-height: 20px;
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