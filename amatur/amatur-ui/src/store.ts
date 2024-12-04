// src/store.js
import { configureStore, createSlice } from "@reduxjs/toolkit";

// Slice for authentication state
const authSlice = createSlice({
  name: "auth",
  initialState: { isLoggedIn: Boolean(localStorage.getItem("token")) },
  reducers: {
    login: (state) => {
      state.isLoggedIn = true;
    },
    logout: (state) => {
      state.isLoggedIn = false;
    },
  },
});

export const { login, logout } = authSlice.actions;

// Configure store
const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;

export default store;
