import React from 'react';

// Existing component
function UserProfile({ user }) {
  // 'user' is expected to have 'id', 'name', AND 'isActive' properties now.
  const statusText = user.isActive ? 'Active' : 'Inactive'; // New logic
  
  return (
    <div className="profile">
      <h1>User Profile</h1>
      <p>ID: {user.id}</p>
      <p>Name: {user.name}</p>
      {/* NEW ELEMENT */}
      <p>Status: {statusText}</p>
    </div>
  );
}
export default UserProfile;
