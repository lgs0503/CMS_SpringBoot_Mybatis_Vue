<script setup lang="ts">
import { RouterView } from 'vue-router'
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
import {reactive, ref} from "vue";
import {useI18n} from "vue-i18n";

let isShowMenu = ref(true);
let isLang = ref(true); // true KOR / false ENG
let isShowChildMenu = reactive([true, true, true]);

const COMMON_MENU = 0;
const CMS_MENU = 1;
const HISTORY_MENU = 2;

const i18n = useI18n();

const childMenuShowHidden = (index:number) => {
  isShowChildMenu[index] = !isShowChildMenu[index];
}

const menuShowHidden = () => {
  isShowMenu.value = !isShowMenu.value;
}

const changeLocale = () => {
  if (i18n.locale.value === 'ko') {
    i18n.locale.value = 'en';
  } else {
    i18n.locale.value = 'ko';
  }

  isLang.value = !isLang.value;
}

</script>

<template>
  <header class="admin-header">
    <div class="admin-title">CMS ADMIN</div>
    <nav class="admin-navigation">
      <router-link tag="a" to="/admin/home">Home</router-link>
      <router-link tag="a" to="/admin/myPage">MyPage</router-link>
      <router-link tag="a" to="/admin/login">SignOut</router-link>
    </nav>
  </header>

  <div class="admin-body">
    <aside class="admin-menu" v-show="isShowMenu">
      <ul>
        <li class="menu-tab">
          <a class="parent-menu" @click="childMenuShowHidden(COMMON_MENU)">
            <span>COMMON</span>
            <font-awesome-icon :icon="['fas', 'caret-up']" />
          </a>
          <ul class="child-menu" v-show="isShowChildMenu[COMMON_MENU]">
            <li><router-link tag="a" to="/admin/code">{{ $t('admin.layout.menu.code') }}</router-link></li>
            <li><router-link tag="a" to="/admin/user">{{ $t('admin.layout.menu.user') }}</router-link></li>
            <li><router-link tag="a" to="/admin/role">{{ $t('admin.layout.menu.role') }}</router-link></li>
            <li><router-link tag="a" to="/admin/menu">{{ $t('admin.layout.menu.menu') }}</router-link></li>
            <li><router-link tag="a" to="/admin/menuRole">{{ $t('admin.layout.menu.menuRole') }}</router-link></li>
            <li><router-link tag="a" to="/admin/file">{{ $t('admin.layout.menu.file') }}</router-link></li>
          </ul>
        </li>
        <li class="menu-tab">
          <a class="parent-menu" @click="childMenuShowHidden(CMS_MENU)">
            <span>CMS</span>
            <font-awesome-icon :icon="['fas', 'caret-up']" />
          </a>
          <ul class="child-menu" v-show="isShowChildMenu[CMS_MENU]">
            <li><router-link tag="a" to="/admin/board">{{ $t('admin.layout.menu.board') }}</router-link></li>
            <li><router-link tag="a" to="/admin/post">{{ $t('admin.layout.menu.post') }}</router-link></li>
            <li><router-link tag="a" to="/admin/content">{{ $t('admin.layout.menu.content') }}</router-link></li>
            <li><router-link tag="a" to="/admin/comment">{{ $t('admin.layout.menu.comment') }}</router-link></li>
            <li><router-link tag="a" to="/admin/like">{{ $t('admin.layout.menu.like') }}</router-link></li>
            <li><router-link tag="a" to="/admin/banner">{{ $t('admin.layout.menu.banner') }}</router-link></li>
            <li><router-link tag="a" to="/admin/popup">{{ $t('admin.layout.menu.popup') }}</router-link></li>
          </ul>
        </li>
        <li class="menu-tab">
          <a class="parent-menu" @click="childMenuShowHidden(HISTORY_MENU)">
            <span>HISTORY</span>
            <font-awesome-icon :icon="['fas', 'caret-up']" />
          </a>
          <ul class="child-menu" v-show="isShowChildMenu[HISTORY_MENU]">
            <li><router-link tag="a" to="/admin/loginHis">{{ $t('admin.layout.menu.loginHis') }}</router-link></li>
            <li><router-link tag="a" to="/admin/fileUpDownHis">{{ $t('admin.layout.menu.fileUpDownHis') }}</router-link></li>
            <li><router-link tag="a" to="/admin/menuUseHis">{{ $t('admin.layout.menu.menuUseHis') }}</router-link></li>
          </ul>
        </li>
      </ul>
    </aside>
    <section class="admin-content">
      <div class="content-top-bar">
        <div class="menu-show">
          <font-awesome-icon v-if="isShowMenu" :icon="['fas', 'caret-left']" @click="menuShowHidden"/>
          <font-awesome-icon v-if="!isShowMenu" :icon="['fas', 'caret-right']" @click="menuShowHidden"/>
        </div>
        <div class="content-title">메뉴명</div>
        <div class="btn-language">
          <font-awesome-icon v-if="isLang" :icon="['fas', 'k']" @click="changeLocale"/>
          <font-awesome-icon v-if="!isLang" :icon="['fas', 'e']" @click="changeLocale"/>
        </div>
      </div>
      <div class="content">
        <RouterView/>
      </div>
    </section>
  </div>

  <footer class="admin-footer">
    <div>ⓒ CMS Admin. copyright(c) {{ new Date().getFullYear() }} All rights reserved</div>
    <a href="https://github.com/lgs0503/CMS_SpringBoot_Mybatis_Vue" target="_blank">GitHub <font-awesome-icon :icon="['fab', 'github']" /></a>
  </footer>
</template>
<style lang="scss" scoped>
  @import "../src/assets/mixin.scss";

  .admin-header {
    height: 50px;
    background: #{$blue-dark-color};
    display: flex;
    justify-content: space-between;
    box-sizing: border-box;
    border-bottom: orangered 4px solid;

    .admin-title {
      line-height: 50px;
      margin: 0 20px;
      display: inline-block;
      color: #{$white-color};
      font-size: 23px;
      font-weight: bold;
    }

    .admin-navigation {
      display: inline-block;
      margin-right: 15px;

      a {
        transition: 0.5s;
        color: #{$white-color};
        font-weight: bold;
        line-height: 50px;
        text-decoration: none;
        margin-left: 20px;
      }

      a:hover {
        color: #{$black-color};
      }
    }
  }

  .admin-body {
    display: flex;
    border-bottom: 1px solid #{$sliver-dark-color};

    .admin-menu {
      display: inline-block;
      width: 300px;
      min-height: calc( 100vh - 100px );
      border-right: 0.3px solid #{$sliver-dark-color};

      .menu-tab {
        border-bottom: 1px solid #{$sliver-dark-color};
      }

      .parent-menu{
        display: flex;
        justify-content: space-between;
        border-bottom: 1px solid #{$sliver-dark-color};
        border-left: 5px solid #{$blue-dark-color};
        color: #{$sliver-dark-color};
        font-weight: bold;
        box-sizing: border-box;
        cursor: pointer;

        span, svg {
          padding : 10px;
        }

        svg {
          color: #{$black-color};
        }
      }

      .child-menu{
        li {
          a {
            padding : 10px;
            text-decoration: none;
            color: #{$sliver-light-color};
            font-weight: bold;
            display: block;
          }

          a:hover {
            transition: 0.5s;
            padding : 10px;
            background: #{$blue-dark-color};
            color: #{$white-color};
          }
        }
      }
    }

    .admin-content {
      min-height: calc( 100vh - 100px );
      display: inline-block;
      background: #{$white-color};
      width: 100%;

      .content-top-bar{
        display: flex;
        border-bottom: 1px solid #{$sliver-dark-color};
        background-color: #{$sliver-light-color};

        div {
          background-color: #{$white-color};
          display: inline-block;
          width: 40px;
          cursor: pointer;

          svg {
            color: #{$blue-dark-color};
            width: 40px;
            transition: 0.5s;
          }

          svg:hover {
            color: #{$black-color};
          }
        }

        .menu-show{
          border-right: 1px solid #{$sliver-dark-color};
          margin-right: 0.5px;

          svg {
            font-size: 35px;
          }
        }

        .content-title{
          color: #{$sliver-dark-color};
          font-weight: bold;
          background-color: #{$white-color};
          display: inline-block;
          min-width: 150px;
          padding : 10px 50px 10px 15px;
          border-left: 1px solid #{$sliver-dark-color};
          border-right: 1px solid #{$sliver-dark-color};
        }

        .btn-language {
          margin-left: auto;
          border-left: 1px solid #{$sliver-dark-color};
          position: relative;

          svg {
            font-size: 20px;
            position: absolute;
            top: 7px;
          }
        }
      }
    }

    .content {
      background-color: #{$sliver-bright-color};
    }
  }

  .admin-footer {
    display: flex;
    justify-content: space-between;
    padding: 3px;

    a {
      text-decoration: none;
      color: #{$black-color};
    }
  }
</style>
