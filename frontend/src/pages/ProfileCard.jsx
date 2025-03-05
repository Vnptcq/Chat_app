import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const ProfileCard = () => {
  const [activeTab, setActiveTab] = useState("one");

  return (
    <div className="col-sm-6 col-md-4 col-lg-3 mt-4">
      <div className="card">
        <img className="card-img-top" src="https://picsum.photos/200/150/?random" alt="Banner" />
        <div className="card-block text-center">
          <figure className="profile">
            <img src="https://picsum.photos/200/150/?random" className="profile-avatar rounded-circle" alt="Avatar" />
          </figure>
          <h4 className="card-title mt-3">NameName</h4>
          <div className="meta">
            <span className="badge badge-primary">Friends</span>
          </div>
          <p className="card-text">hihi</p>
        </div>

        {/* Tabs */}
        <div className="card-footer">
          <ul className="nav nav-tabs card-header-tabs">
            {["one", "two", "three"].map((tab) => (
              <li className="nav-item" key={tab}>
                <button
                  className={`nav-link ${activeTab === tab ? "active" : ""}`}
                  onClick={() => setActiveTab(tab)}
                >
                  {tab.charAt(0).toUpperCase() + tab.slice(1)}
                </button>
              </li>
            ))}
          </ul>
        </div>

        {/* Tab Content */}
        <div className="tab-content p-3">
          {activeTab === "one" && (
            <div>
              <h5 className="card-title">Tab Card One</h5>
              <p className="card-text">Some quick example text to build on the card title.</p>
              <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
          )}
          {activeTab === "two" && (
            <div>
              <h5 className="card-title">Tab Card Two</h5>
              <p className="card-text">Some quick example text to build on the card title.</p>
              <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
          )}
          {activeTab === "three" && (
            <div>
              <h5 className="card-title">Tab Card Three</h5>
              <p className="card-text">Some quick example text to build on the card title.</p>
              <a href="#" className="btn btn-primary">Go somewhere</a>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default ProfileCard;
