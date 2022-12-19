<template>
    <a-layout-header class="header">
        <div class="logo" />
        <a-menu
                v-model:selectedKeys="selectedKeys1"
                theme="dark"
                mode="horizontal"
                :style="{ lineHeight: '64px' }"
        >
            <a-menu-item key="/">
                <router-link to="/">首页</router-link>
            </a-menu-item>
            <a-menu-item key="/admin/newsList">
                <router-link to="/admin/newsList">新闻管理</router-link>
            </a-menu-item>
            <a-menu-item key="3">nav 3</a-menu-item>
        </a-menu>
    </a-layout-header>
</template>

<script language="ts">
    import { defineComponent } from 'vue';
    export default defineComponent({
        name: 'the-header',
    });
</script>

<style scoped>

</style>