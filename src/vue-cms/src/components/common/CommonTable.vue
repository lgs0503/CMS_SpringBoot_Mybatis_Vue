<script setup lang="ts">

  const props = defineProps({
    column: {
      Type: Array,
      default: []
    },
    mainKey: {
      Type: String,
      default: ""
    },
    data:{
      Type: Array,
      default: []
    }
  });

  const emit = defineEmits([
    'rowClickEvent'
  ]);

  const rowClickEvent = (index:number) => {

    console.log(props.data[index-1][`${props.mainKey}`]);

    emit('rowClickEvent',{
      indexKey: props.data[index-1][`${props.mainKey}`]
    })
  }
</script>

<template>
  <table>
    <colgroup>
      <col v-for="col in props.column" :style="`width:${col.width}px`"/>
    </colgroup>
    <thead>
      <tr>
        <th v-for="col in props.column" v-show="col.visible">
          {{ col.name }}
        </th>
      </tr>
    </thead>
    <tbody>

      <tr v-if="props.data.length === 0" >
        <td :colspan="props.column.length">
          조회 데이터가 없습니다.
        </td>
      </tr>

      <tr
          v-else
          v-for="row in props.data"
          class="rowOver">
        <td
            v-for="(col, index) in props.column"
            :key="index"
            @click="rowClickEvent(index)"
        >
          {{ row[col.field] }}
        </td>
      </tr>
    </tbody>
  </table>
</template>
<style lang="scss" scoped>
  @import "../src/assets/variables.scss";

  table {

    width: 100%;
    border: 1px solid #{$black-color};
    font-size: 10px;

    thead {
      tr {
        th {
          background-color: #{$blue-dark-color};
          color: white;
          font-weight: bold;
          padding: 7px 0;
        }
        th:nth-child(even) {
          background-color: #{$blue-deep-dark-color};
        }
      }
    }

    tbody {
      tr {
        td {
          background-color: #{$white-color};
          color: #{$sliver-dark-color};
          font-weight: bold;
          padding: 7px;
          text-align: center;
        }

        td:nth-child(even) {
          background-color: #{$sliver-bright-color};
        }
      }

      .rowOver:hover {
        cursor: pointer;

         td {
           background-color: #{$blue-light-color};
           color : #{$white-color};
         }
      }
    }
  }
</style>
