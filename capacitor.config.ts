import { CapacitorConfig } from '@capacitor/cli'

const config: CapacitorConfig = {
  appId: 'io.phloxcorp.eldo.qa2',
  appName: 'Capacitor Test',
  webDir: 'dist',
  bundledWebRuntime: false,
  plugins: {
    GoogleAuth: {
      scopes: ['profile', 'email'],
      serverClientId: '450429795824-6ms86sk1kispv9hn8jf53t3lf4ij2sk9.apps.googleusercontent.com',
      forceCodeForRefreshToken: true
    }
  }
}

export default config
