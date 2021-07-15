<template>
  <div class="about">
    <h1>This is an about page</h1>
    <button @click="onClick">Google Login</button>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

import GoogleAuth from '@/google'

export default defineComponent({
  methods: {
    async onClick () {
      const response = await GoogleAuth.signIn()
      console.log(response)
    }
  }
})
</script>
