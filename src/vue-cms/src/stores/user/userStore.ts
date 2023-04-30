import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import {LOGIN} from "@/api/user/userApi";
import type {Login, UserModel} from "@/model/user/userModel";

export const useUserStore = defineStore('user', () => {
  const userList = ref([])

  const getUserList = computed(() =>
      userList.value
  );

  const login = async (login: Login) => {
    return await LOGIN(login);
  }

  const insertUser = (user : UserModel) => {

  }

  const updateUser = (user : UserModel) => {

  }

  const deleteUser = (userIds : Array<number>) => {

  }

  return { userList, getUserList, login, insertUser, updateUser, deleteUser }
})
