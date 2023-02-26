package com.gmrodriguez.todoapp.mapper;

public interface IMapper <I, O>{
    public O map(I input);
}
