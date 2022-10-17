import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorComponent } from './doctor/doctor.component';
import { DoctorappointmentsComponent } from './doctorappointments/doctorappointments.component';
import { DoctorPatientsComponent } from './doctor-patients/doctor-patients.component';
import { ApplyJobComponent } from './apply-job/apply-job.component';
import { ViewIdComponent } from './view-id/view-id.component';

@NgModule({
  declarations: [
    AppComponent,
    DoctorComponent,
    DoctorappointmentsComponent,
    DoctorPatientsComponent,
    ApplyJobComponent,
    ViewIdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
