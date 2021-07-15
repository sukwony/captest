<template>
  <div class="about">
    <h1>This is an about page</h1>
    <button @click="onClick">Google Login</button>
    <button @click="onClickCallEchoPlugin">Call Echo Plugin</button>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

import { Toast } from '@capacitor/toast'
import Echo from '@/echo'
import GoogleAuth from '@/google'

export default defineComponent({
  methods: {
    async onClick () {
      const response = await GoogleAuth.signIn()
      console.log(response)
    },
    async onClickCallEchoPlugin () {
      const { value } = await Echo.echo({ value: 'Hello World' })
      await Toast.show({ text: `from plugin: ${value}` })
    }
  }
})
</script>
