// Register.js
import React from "react";
import RegisterForm from "./RegisterForm"; // Import the RegisterForm component
import { useRegisterLogic } from "./useRegisterLogic"; // Import the logic

const Register = () => {
  const { register, handleSubmit, errors, isSubmitting, onSubmit, getValues } =
    useRegisterLogic();

  return (
    <div className="register-page">
      <RegisterForm
        register={register}
        handleSubmit={handleSubmit}
        errors={errors}
        isSubmitting={isSubmitting}
        onSubmit={onSubmit}
        getValues={getValues}
      />
    </div>
  );
};

export default Register;
