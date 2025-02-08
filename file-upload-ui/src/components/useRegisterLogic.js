// useRegisterLogic.js
import { useForm } from "react-hook-form";
import { useState } from "react";

export const useRegisterLogic = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    getValues,
  } = useForm();
  const [isSubmitting, setIsSubmitting] = useState(false);

  const onSubmit = async (data) => {
    setIsSubmitting(true);
    // Simulate form submission (You can replace this with your API call)
    setTimeout(() => {
      console.log("User Registered: ", data);
      setIsSubmitting(false);
      alert("Registration successful");
    }, 2000);
  };

  return {
    register,
    handleSubmit,
    errors,
    isSubmitting,
    onSubmit,
    getValues,
  };
};
