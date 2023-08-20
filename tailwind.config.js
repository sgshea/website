/** @type {import('tailwindcss').Config} */
module.exports = {
  content: process.env.NODE_ENV == 'production' ? ["./public/js/app.js"] : ["./src/**/*.cljs", "./public/js/cljs-runtime/*.js"],
  theme: {
    extend: {},
  },
  plugins: [require("@tailwindcss/typography"), require("daisyui")],
}

