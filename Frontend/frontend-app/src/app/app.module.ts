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
import { DoctorLoginComponent } from './doctor-login/doctor-login.component';
import { DoctorSignupComponent } from './doctor-signup/doctor-signup.component';
import { DischargedPatientComponent } from './discharged-patient/discharged-patient.component';
import { PatientAdmitComponent } from './Patient/patient-admit/patient-admit.component';
import { PatientAppointmentComponent } from './Patient/patient-appointment/patient-appointment.component';
import { PatientDoctorComponent } from './Patient/patient-doctor/patient-doctor.component';
import { PatientComponent } from './Patient/patient/patient.component';
import { GetDocidComponent } from './get-docid/get-docid.component';
import { GetpatidComponent } from './Patient/getpatid/getpatid.component';

@NgModule({
  declarations: [
    AppComponent,
    DoctorComponent,
    DoctorappointmentsComponent,
    DoctorPatientsComponent,
    ApplyJobComponent,
    ViewIdComponent,
    DoctorLoginComponent,
    DoctorSignupComponent,
    DischargedPatientComponent,
    PatientAdmitComponent,
    PatientAppointmentComponent,
    PatientDoctorComponent,
    PatientComponent,
    GetDocidComponent,
    GetpatidComponent
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
