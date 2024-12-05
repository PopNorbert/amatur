
import { configureStore } from "@reduxjs/toolkit";
import contestsReducer from "./features/contestsSlice";
import authReducer from "./features/authSlice"

const store = configureStore({
  reducer: {
    contests: contestsReducer,
    auth: authReducer
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
export default store;