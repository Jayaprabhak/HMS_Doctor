import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplyJobComponent } from './apply-job/apply-job.component';
import { DischargedPatientComponent } from './discharged-patient/discharged-patient.component';
import { DoctorLoginComponent } from './doctor-login/doctor-login.component';
import { DoctorPatientsComponent } from './doctor-patients/doctor-patients.component';
import { DoctorSignupComponent } from './doctor-signup/doctor-signup.component';
import { DoctorComponent } from './doctor/doctor.component';
import { DoctorappointmentsComponent } from './doctorappointments/doctorappointments.component';
import { GetDocidComponent } from './get-docid/get-docid.component';
import { GetpatidComponent } from './Patient/getpatid/getpatid.component';
import { PatientAdmitComponent } from './Patient/patient-admit/patient-admit.component';
import { PatientAppointmentComponent } from './Patient/patient-appointment/patient-appointment.component';
import { PatientDoctorComponent } from './Patient/patient-doctor/patient-doctor.component';
import { PatientComponent } from './Patient/patient/patient.component';
import { ViewIdComponent } from './view-id/view-id.component';

const routes: Routes = [
  {path:"doctor",component:DoctorComponent, children :[
  {path:"getid", component:GetDocidComponent},
  {path:"viewApp", component:DoctorappointmentsComponent},
  {path:"viewPat", component:DoctorPatientsComponent},
  {path:"dispat", component:DischargedPatientComponent} ]},
  {path:"viewId", component:ViewIdComponent},
  {path:"applyJob", component:ApplyJobComponent},
  {path:"login", component:DoctorLoginComponent},
  {path:"signup", component:DoctorSignupComponent},
  {path:"",redirectTo:"login",pathMatch:"full"},

  {path:"patient",component:PatientComponent, children :[
  {path:"getpatid", component:GetpatidComponent},
  {path:"appointment", component:PatientAppointmentComponent},                     //need to add
  {path:"viewdoc", component:PatientDoctorComponent},
  {path:"savepat", component:PatientAdmitComponent} ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
